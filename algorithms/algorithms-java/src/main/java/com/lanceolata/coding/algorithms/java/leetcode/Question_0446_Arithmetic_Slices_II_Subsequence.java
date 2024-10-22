package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;

public class Question_0446_Arithmetic_Slices_II_Subsequence {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;
        HashMap<Long, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = new HashMap<>();
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - (long) nums[j];
                int cnt = dp[j].getOrDefault(diff, 0);
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + cnt + 1);
                ans += cnt;
            }
        }
        return ans;
    }
}
