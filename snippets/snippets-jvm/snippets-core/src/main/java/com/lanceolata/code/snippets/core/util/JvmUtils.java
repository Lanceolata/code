package com.lanceolata.code.snippets.core.util;

import com.sun.management.GarbageCollectionNotificationInfo;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import javax.management.ListenerNotFoundException;
import javax.management.Notification;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;
import java.lang.management.*;
import java.util.*;
import java.util.stream.Collectors;

public class JvmUtils {

    public static int getPid() {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String pidStr = name.split("@", 2)[0];
        return Integer.parseInt(pidStr);
    }

    /**
     * =================================================
     * Class Load
     */

    public static long getLoadedClassCount() {
        return ManagementFactory.getClassLoadingMXBean().getLoadedClassCount();
    }

    public static long getUnloadedClassCount() {
        return ManagementFactory.getClassLoadingMXBean().getUnloadedClassCount();
    }

    /**
     * =================================================
     * Thread
     */

    /**
     * 获得线程数
     * Triple<当前线程数，峰值线程数，守护线程数>
     *
     * @return
     */
    public static Triple<Integer, Integer, Integer> getThreadCount() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        return Triple.of(
                threadMXBean.getThreadCount(),
                threadMXBean.getPeakThreadCount(),
                threadMXBean.getDaemonThreadCount());
    }

    public static Map<Thread.State, Long> getThreadStateCount() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        return Arrays.stream(threadMXBean.getThreadInfo(threadMXBean.getAllThreadIds()))
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(ThreadInfo::getThreadState, Collectors.counting()));
    }

    /**
     * =================================================
     * Memory
     */

    public static Triple<Long, Long, Long> getHeapMemoryUsage() {
        MemoryUsage memoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        return Triple.of(memoryUsage.getUsed(), memoryUsage.getMax(), memoryUsage.getCommitted());
    }

    public static Triple<Long, Long, Long> getNonHeapMemoryUsage() {
        MemoryUsage memoryUsage = ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage();
        return Triple.of(memoryUsage.getUsed(), memoryUsage.getMax(), memoryUsage.getCommitted());
    }

    public static Map<String, Triple<Long, Long, Long>> getBufferPoolMemoryUsage() {
        return ManagementFactory.getPlatformMXBeans(BufferPoolMXBean.class).stream()
                .collect(Collectors.toMap(
                        BufferPoolMXBean::getName,
                        t -> Triple.of(t.getCount(), t.getMemoryUsed(), t.getTotalCapacity())
                ));
    }

    public static Map<Pair<String, String>, Triple<Long, Long, Long>> getMemoryPoolMemoryUsage() {
        return ManagementFactory.getPlatformMXBeans(MemoryPoolMXBean.class).stream()
                .collect(Collectors.toMap(
                        t -> Pair.of(t.getType().name(), t.getName()),
                        t -> Triple.of(t.getUsage().getUsed(), t.getUsage().getMax(), t.getUsage().getCommitted())
                ));
    }

    /**
     * =================================================
     * GC
     */

    public static List<Pair<GarbageCollectorMXBean, GcNotificationListener>> addNotificationListeners() {
        List<Pair<GarbageCollectorMXBean, GcNotificationListener>> ret = new ArrayList<>();
        for (GarbageCollectorMXBean mbean : ManagementFactory.getGarbageCollectorMXBeans()) {
            if (!(mbean instanceof NotificationEmitter)) {
                return null;
            }
            GcNotificationListener listener = addNotificationListener(mbean);
            ret.add(Pair.of(mbean, listener));
        }
        return ret;
    }

    public static GcNotificationListener addNotificationListener(GarbageCollectorMXBean mbean) {
        GcNotificationListener listener = new GcNotificationListener();
        NotificationEmitter notificationEmitter = (NotificationEmitter) mbean;
        notificationEmitter.addNotificationListener(listener, null, null);
        return listener;
    }

    public static void removeNotificationListeners(List<Pair<GarbageCollectorMXBean, GcNotificationListener>> listeners) {
        for (Pair<GarbageCollectorMXBean, GcNotificationListener> p : listeners) {
            try {
                removeNotificationListener(p.getKey(), p.getValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void removeNotificationListener(GarbageCollectorMXBean mbean, GcNotificationListener listener) throws ListenerNotFoundException {
        NotificationEmitter notificationEmitter = (NotificationEmitter) mbean;
        notificationEmitter.removeNotificationListener(listener);
    }

    static class GcNotificationListener implements NotificationListener {

        private final long jvmStartTime;

        private String youngGenPoolName;
        private String oldGenPoolName;

        private volatile GCEvent curEvent;

        public GcNotificationListener() {
            jvmStartTime = ManagementFactory.getRuntimeMXBean().getStartTime();
            for (MemoryPoolMXBean mbean : ManagementFactory.getMemoryPoolMXBeans()) {
                String name = mbean.getName();
                if (isYoungGenPool(name)) {
                    youngGenPoolName = name;
                } else if (isOldGenPool(name)) {
                    oldGenPoolName = name;
                }
            }
        }

        @Override
        public void handleNotification(Notification notification, Object handback) {
            if (!notification.getType().equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION)) {
                return;
            }

            GarbageCollectionNotificationInfo info = getGCNotificationInfo(notification);

            GCEvent event = new GCEvent();
            event.setName(info.getGcName());
            event.setCause(info.getGcCause());
            event.setAction(info.getGcAction());

            if (isConcurrentPhase(info.getGcCause())) {
                // Time spent in concurrent phase
                event.setPhase(GCPhase.CONCURRENT);
            } else {
                // Time spent in GC pause
                event.setPhase(GCPhase.PAUSE);
            }
            event.setDuration(info.getGcInfo().getDuration());

            if (oldGenPoolName != null) {
                parseOldGenGCInfo(info, event);
            }

            if (youngGenPoolName != null) {
                parseYoungGenGCInfo(info, event);
            }

            curEvent = event;
        }

        private boolean isYoungGenPool(String name) {
            return name.endsWith("Eden Space");
        }

        private boolean isOldGenPool(String name) {
            return name.endsWith("Old Gen") || name.endsWith("Tenured Gen");
        }

        private GarbageCollectionNotificationInfo getGCNotificationInfo(Notification notification) {
            CompositeData cd = (CompositeData) notification.getUserData();
            return GarbageCollectionNotificationInfo.from(cd);
        }

        private boolean isConcurrentPhase(String cause) {
            return "No GC".equals(cause);
        }

        private void parseOldGenGCInfo(GarbageCollectionNotificationInfo info, GCEvent event) {
            // Update promotion and allocation counters
            final MemoryUsage before = info.getGcInfo().getMemoryUsageBeforeGc().get(oldGenPoolName);
            final MemoryUsage after = info.getGcInfo().getMemoryUsageAfterGc().get(oldGenPoolName);

            event.setOldGenMemoryUsed(after.getUsed());
            event.setOldGenMemoryMax(after.getMax());
            long delta = before.getUsed() - after.getUsed();
            if (delta > 0L) {
                event.setOldGenMemoryPromoted(before.getUsed() - after.getUsed());
            }
        }

        private void parseYoungGenGCInfo(GarbageCollectionNotificationInfo info, GCEvent event) {
            // Update promotion and allocation counters
            final MemoryUsage before = info.getGcInfo().getMemoryUsageBeforeGc().get(youngGenPoolName);
            final MemoryUsage after = info.getGcInfo().getMemoryUsageAfterGc().get(youngGenPoolName);
            long delta = before.getUsed() - after.getUsed();
            if (delta > 0L) {
                event.setYoungGenMemoryAllocated(delta);
            }
        }

        static class GCEvent {

            private String name;
            private String cause;
            private String action;
            private GCPhase phase;
            private long duration;

            private long oldGenMemoryUsed;
            private long oldGenMemoryMax;
            private long oldGenMemoryPromoted;
            private long youngGenMemoryAllocated;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCause() {
                return cause;
            }

            public void setCause(String cause) {
                this.cause = cause;
            }

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
            }

            public GCPhase getPhase() {
                return phase;
            }

            public void setPhase(GCPhase phase) {
                this.phase = phase;
            }

            public long getDuration() {
                return duration;
            }

            public void setDuration(long duration) {
                this.duration = duration;
            }

            public long getOldGenMemoryUsed() {
                return oldGenMemoryUsed;
            }

            public void setOldGenMemoryUsed(long oldGenMemoryUsed) {
                this.oldGenMemoryUsed = oldGenMemoryUsed;
            }

            public long getOldGenMemoryMax() {
                return oldGenMemoryMax;
            }

            public void setOldGenMemoryMax(long oldGenMemoryMax) {
                this.oldGenMemoryMax = oldGenMemoryMax;
            }

            public long getOldGenMemoryPromoted() {
                return oldGenMemoryPromoted;
            }

            public void setOldGenMemoryPromoted(long oldGenMemoryPromoted) {
                this.oldGenMemoryPromoted = oldGenMemoryPromoted;
            }

            public long getYoungGenMemoryAllocated() {
                return youngGenMemoryAllocated;
            }

            public void setYoungGenMemoryAllocated(long youngGenMemoryAllocated) {
                this.youngGenMemoryAllocated = youngGenMemoryAllocated;
            }
        }

        enum GCPhase {
            CONCURRENT, PAUSE;
        }

        enum GcGenerationAge {
            OLD,
            YOUNG,
            UNKNOWN;

            private static Map<String, GcGenerationAge> knownCollectors = new HashMap<String, GcGenerationAge>() {{
                put("ConcurrentMarkSweep", OLD);
                put("Copy", YOUNG);
                put("G1 Old Generation", OLD);
                put("G1 Young Generation", YOUNG);
                put("MarkSweepCompact", OLD);
                put("PS MarkSweep", OLD);
                put("PS Scavenge", YOUNG);
                put("ParNew", YOUNG);
            }};

            static GcGenerationAge fromName(String name) {
                return knownCollectors.getOrDefault(name, UNKNOWN);
            }
        }

    }

}
