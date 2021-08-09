package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question_0523_Continuous_Subarray_Sum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            int t = (k == 0) ? sum : (sum % k);
            if (map.containsKey(t)) {
                if (i - map.get(t) > 1) {
                    return true;
                }
            } else {
                map.put(t, i);
            }
        }
        return false;
    }
}
