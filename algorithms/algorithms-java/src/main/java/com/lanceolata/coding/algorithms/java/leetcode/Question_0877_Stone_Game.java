package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0877_Stone_Game {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int d = 1; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                dp[i][i + d] = Math.max(piles[i] - dp[i + 1][i + d], piles[i + d] - dp[i][i + d - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }

    public boolean stoneGame_simple(int[] piles) {
        return true;
    }
}
