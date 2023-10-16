package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1043_Partition_Array_for_Maximum_Sum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[k];
        for (int i = 1; i <= n; ++i) {
            int curMax = 0, best = 0;
            for (int j = 1; j <= k && i - j >= 0; ++j) {
                curMax = Math.max(curMax, arr[i - j]);
                best = Math.max(best, dp[(i - j) % k] + curMax * j);
            }
            dp[i % k] = best;
        }
        return dp[n % k];
    }
}
