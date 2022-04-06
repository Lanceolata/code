package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.TreeMap;

public class Question_0870_Advantage_Shuffle {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int i : nums1) {
            m.put(i, m.getOrDefault(i, 0) + 1);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            Integer x = m.higherKey(nums2[i]);
            if (x == null) {
                x = m.firstKey();
            }
            m.put(x, m.get(x) - 1);
            if (m.get(x) == 0) {
                m.remove(x);
            }
            res[i] = x;
        }
        return res;
    }
}
