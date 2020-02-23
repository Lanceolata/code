package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0053_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        if (nums == null || nums.length == 0) {
            return res;
        }
        int cur = 0;
        for (int n : nums) {
            cur += n;
            res = Math.max(res, cur);
            if (cur < 0) {
                cur = 0;
            }
        }
        return res;
    }
}
