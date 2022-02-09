package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question_0659_Split_Array_into_Consecutive_Subsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), need = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (freq.get(num) == 0) {
                continue;
            }
            if (need.getOrDefault(num, 0) > 0) {
                need.put(num, need.getOrDefault(num, 0) - 1);
                need.put(num + 1, need.getOrDefault(num + 1, 0) + 1);
            } else if (freq.getOrDefault(num + 1, 0) > 0
                    && freq.getOrDefault(num + 2, 0) > 0) {
                freq.put(num + 1, freq.getOrDefault(num + 1, 0) - 1);
                freq.put(num + 2, freq.getOrDefault(num + 2, 0) - 1);
                need.put(num + 3, need.getOrDefault(num + 3, 0) + 1);
            } else {
                return false;
            }
            freq.put(num, freq.get(num) - 1);
        }
        return true;
    }
}
