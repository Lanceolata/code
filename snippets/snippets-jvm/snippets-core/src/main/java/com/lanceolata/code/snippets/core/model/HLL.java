package com.lanceolata.code.snippets.core.model;

import org.apache.datasketches.hll.HllSketch;
import org.apache.datasketches.hll.Union;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * HLL包装类
 * 注：非线程安全
 */
public class HLL implements Externalizable {
    /**
     * 直接使用Union对象
     */
    private Union union;

    public HLL() {
        this.union = new Union();
    }

    private HLL(Union union) {
        this.union = union;
    }

    public static byte[] serializeToByteArray(HLL hll) {
        return hll.union.toCompactByteArray();
    }

    public static HLL deserializeFromByteArray(byte[] bytes) {
        return new HLL(Union.heapify(bytes));
    }

    public HLL update(final String str) {
        union.update(str);
        return this;
    }

    public HLL union(final HLL hll) {
        union.update(hll.union.getResult());
        return this;
    }

    public double getEstimate() {
        return union.getEstimate();
    }

    public byte[] toCompactByteArray() {
        return union.toCompactByteArray();
    }

    public HllSketch getHllSketch() {
        return union.getResult();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.write(union.toCompactByteArray());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        byte[] bytes = new byte[in.available()];
        in.readFully(bytes);
        union = Union.heapify(bytes);
    }
}
