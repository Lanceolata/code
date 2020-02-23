package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0221_Maximal_Square {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length, pre = 0, res = 0;
        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                int tmp = dp[j];
                if (matrix[i][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], pre), dp[j]) + 1;
                    res = Math.max(dp[j], res);
                } else {
                    dp[j] = 0;
                }
                pre = tmp;
            }
        }
        return res * res;
    }
}
