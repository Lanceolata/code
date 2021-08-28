package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0576_Out_of_Boundary_Paths {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod = 1000000007;
        int[][] dp = new int[m][n];
        for (int move = 1; move <= maxMove; move++) {
            int[][] tmp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    long count = 0;
                    count += i == 0 ? 1 : dp[i - 1][j];
                    count += i == m - 1 ? 1 : dp[i + 1][j];
                    count += j == 0 ? 1 : dp[i][j - 1];
                    count += j == n - 1 ? 1 : dp[i][j + 1];
                    tmp[i][j] = (int) (count % mod);
                }
            }
            dp = tmp;
        }
        return dp[startRow][startColumn];
    }
}
