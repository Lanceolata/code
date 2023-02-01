package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0300_Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        int res = 0, cur = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cur = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    cur = Math.max(cur, dp[j]);
                }
            }
            dp[i] = cur + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lengthOfLISOpt(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
