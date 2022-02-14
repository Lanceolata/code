package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0674_Longest_Continuous_Increasing_Subsequence {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1, cur = 1;
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] <= nums[i - 1]) {
                res = Math.max(res, cur);
                cur = 1;
            } else {
                cur++;
            }
        }
        return res;
    }
}
