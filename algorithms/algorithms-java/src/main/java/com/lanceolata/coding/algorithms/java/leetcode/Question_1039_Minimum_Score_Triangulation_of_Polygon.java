package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1039_Minimum_Score_Triangulation_of_Polygon {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int j = 2; j < n; ++j) {
            for (int i = j - 2; i >= 0; --i) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[j] * values[k]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
