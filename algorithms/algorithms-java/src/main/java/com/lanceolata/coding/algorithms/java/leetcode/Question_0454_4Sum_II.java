package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question_0454_4Sum_II {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            for (int j : B) {
                if (map.containsKey(i + j)) {
                    map.put(i + j, map.get(i + j) + 1);
                } else {
                    map.put(i + j, 1);
                }
            }
        }
        int res = 0;
        for (int i : C) {
            for (int j : D) {
                if (map.containsKey(-(i + j))) {
                    res += map.get(-(i + j));
                }
            }
        }
        return res;
    }
}
