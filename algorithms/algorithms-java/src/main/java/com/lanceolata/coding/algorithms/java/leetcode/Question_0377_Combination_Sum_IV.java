package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0377_Combination_Sum_IV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return help(nums, target, dp);
    }

    private int help(int[] nums, int target, int[] dp) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i : nums) {
            if (target >= i) {
                res += help(nums, target - i, dp);
            }
        }
        dp[target] = res;
        return res;
    }
}
