package com.lanceolata.coding.snippets.common.java.utils.bitmap;

import java.util.*;

public class BitSetUtils {
    public static byte[] serialize(BitSet bitset) {
        return bitset.toByteArray();
    }

    public static BitSet deserialize(byte[] bytes) {
        return BitSet.valueOf(bytes);
    }

    public static List<Integer> toList(BitSet bitset) {
        List<Integer> res = new ArrayList<>(bitset.cardinality());
        int n = bitset.nextSetBit(0);
        while (n != -1) {
            res.add(n);
            n = bitset.nextSetBit(n + 1);
        }
        return res;
    }

    public static Set<Integer> toSet(BitSet bitset) {
        Set<Integer> res = new HashSet<>();
        int n = bitset.nextSetBit(0);
        while (n != -1) {
            res.add(n);
            n = bitset.nextSetBit(n + 1);
        }
        return res;
    }
}
