package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class question_0164_Maximum_Gap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            res = Math.max(res, nums[i + 1] - nums[i]);
        }
        return res;
    }
}
