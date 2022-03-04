package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0743_Network_Delay_Time {
    private Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();

    private static class Pair<A, B> {
        public final A key;
        public final B value;

        public Pair(A key, B value) {
            this.key = key;
            this.value = value;
        }

        public static <A, B> Pair<A, B> of(A a, B b) {
            return new Pair<A, B>(a, b);
        }

        public A getKey() {
            return key;
        }

        public B getValue() {
            return value;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];
            if (!adj.containsKey(source)) {
                adj.put(source, new ArrayList<>());
            }
            adj.get(source).add(Pair.of(travelTime, dest));
        }
        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        dijkstra(signalReceivedAt, k);

        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, signalReceivedAt[i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dijkstra(int[] signalReceivedAt, int source) {
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        pq.add(Pair.of(0, source));
        signalReceivedAt[source] = 0;
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> topPair = pq.remove();
            int currNode = topPair.getValue();
            int currNodeTime = topPair.getKey();
            if (currNodeTime > signalReceivedAt[currNode]) {
                continue;
            }
            if (!adj.containsKey(currNode)) {
                continue;
            }
            for (Pair<Integer, Integer> edge : adj.get(currNode)) {
                int time = edge.getKey();
                int neighborNode = edge.getValue();
                if (signalReceivedAt[neighborNode] > currNodeTime + time) {
                    signalReceivedAt[neighborNode] = currNodeTime + time;
                    pq.add(Pair.of(signalReceivedAt[neighborNode], neighborNode));
                }
            }
        }
    }
}
