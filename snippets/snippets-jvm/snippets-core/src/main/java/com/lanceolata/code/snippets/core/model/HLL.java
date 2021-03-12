package com.lanceolata.code.snippets.core.model;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.datasketches.hll.HllSketch;
import org.apache.datasketches.hll.Union;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import java.util.List;

/**
 * HLL类
 * 封装HllSketch
 * 注：非线程安全
 */
public class HLL implements Externalizable {
    /**
     * HllSketch对象
     */
    private HllSketch hllSketch;

    public HLL() {
        this.hllSketch = new HllSketch();
    }

    private HLL(HllSketch hllSketch) {
        this.hllSketch = hllSketch;
    }

    public static HLL zero() {
        return new HLL();
    }

    public static HLL toHLL(String str) {
        return new HLL().update(str);
    }

    /**
     * 并集
     *
     * @param hlls
     * @return
     */
    public static HLL union(HLL... hlls) {
        return union(Arrays.asList(hlls));
    }

    /**
     * 并集
     *
     * @param hlls
     * @return
     */
    public static HLL union(List<HLL> hlls) {
        Union union = new Union();
        for (HLL h : hlls) {
            union.update(h.hllSketch);
        }
        return new HLL(union.getResult());
    }

    /**
     * 交集
     *
     * @param hlls
     * @return
     */
    public static double intersectionSize(HLL... hlls) {
        return intersectionSize(Arrays.asList(hlls));
    }

    /**
     * 交集
     *
     * |A n B| = |A| + |B| - |A u B|
     * in the below, we set A = head, and B = tail.
     * then note that A u (B0 n B1 n ...) = (B0 u A) n (B1 u A) n ...
     * the latter we can compute with tail.map { _ + A } using the HLLInstance +
     * since + on HLLInstance creates the instance for the union.
     *
     * @param hlls
     * @return
     */
    public static double intersectionSize(List<HLL> hlls) {
        if (CollectionUtils.isEmpty(hlls)) {
            return 0.0;
        }
        if (hlls.size() == 1) {
            return hlls.get(0).getEstimate();
        }
        HLL head = hlls.get(0);
        List<HLL> tail = hlls.subList(1, hlls.size());
        List<HLL> unionTail = Lists.newArrayList();
        for (HLL h : tail) {
            unionTail.add(HLL.union(head, h));
        }
        return head.getEstimate() + intersectionSize(tail) - intersectionSize(unionTail);
    }

    public static byte[] serializeToByteArray(HLL hll) {
        return hll.hllSketch.toCompactByteArray();
    }

    public static HLL deserializeFromByteArray(byte[] bytes) {
        return new HLL(HllSketch.heapify(bytes));
    }

    public HLL update(final String str) {
        hllSketch.update(str);
        return this;
    }

    public double getEstimate() {
        return hllSketch.getEstimate();
    }

    public byte[] toCompactByteArray() {
        return hllSketch.toCompactByteArray();
    }

    public HllSketch getHllSketch() {
        return hllSketch;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.write(hllSketch.toCompactByteArray());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        byte[] bytes = new byte[in.available()];
        in.readFully(bytes);
        hllSketch = HllSketch.heapify(bytes);
    }
}
