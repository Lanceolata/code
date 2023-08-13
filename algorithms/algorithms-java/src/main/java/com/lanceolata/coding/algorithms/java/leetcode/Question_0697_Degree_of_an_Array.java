package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question_0697_Degree_of_an_Array {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> f = new HashMap<>(), l = new HashMap<>(), r = new HashMap<>();
        int maxF = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            f.put(n, f.getOrDefault(n, 0) + 1);
            maxF = Math.max(maxF, f.get(n));
            if (!l.containsKey(n)) {
                l.put(n, i);
            }
            r.put(n, i);
        }
        int res = nums.length;
        for (Map.Entry<Integer, Integer> e : f.entrySet()) {
            if (e.getValue() != maxF) {
                continue;
            }
            res = Math.min(res, r.get(e.getKey()) - l.get(e.getKey()) + 1);
        }
        return res;
    }
}
