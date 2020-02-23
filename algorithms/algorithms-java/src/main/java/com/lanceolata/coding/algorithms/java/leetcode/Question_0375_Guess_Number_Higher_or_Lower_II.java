package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0375_Guess_Number_Higher_or_Lower_II {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i > 0; i--) {
                int globalMin = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    globalMin = Math.min(globalMin, k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }
                dp[i][j] = i + 1 == j ? i : globalMin;
            }
        }
        return dp[1][n];
    }
}
