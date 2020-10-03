package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0072_Edit_Distance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m * n == 0) {
            return m + n;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int left = dp[i][j - 1] + 1;
                int down = dp[i - 1][j] + 1;
                int leftdown = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftdown += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, leftdown));
            }
        }
        return dp[m][n];
    }
}
