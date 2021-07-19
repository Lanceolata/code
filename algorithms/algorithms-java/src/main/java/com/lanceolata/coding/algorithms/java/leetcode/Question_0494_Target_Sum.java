package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question_0494_Target_Sum {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        for (int n : nums) {
            Map<Integer, Integer> t = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int sum = entry.getKey(), count = entry.getValue();
                sup(t,sum + n, count);
                sup(t,sum - n, count);
            }
            dp = t;
        }
        if (dp.containsKey(target)) {
            return dp.get(target);
        }
        return 0;
    }

    private void sup(Map<Integer, Integer> m, int k, int v) {
        if (m.containsKey(k)) {
            m.put(k, m.get(k) + v);
        } else {
            m.put(k, v);
        }
    }
}
