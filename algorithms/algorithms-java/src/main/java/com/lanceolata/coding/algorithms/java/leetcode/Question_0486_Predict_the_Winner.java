package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0486_Predict_the_Winner {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return help(nums, 0, n - 1, dp) >= 0;
    }

    private int help(int[] nums, int s, int e, int[][] dp) {
        if (dp[s][e] == -1) {
            dp[s][e] = (s == e) ? nums[s] : Math.max(nums[s] - help(nums, s + 1, e, dp), nums[e] - help(nums, s, e - 1, dp));
        }
        return dp[s][e];
    }
}
