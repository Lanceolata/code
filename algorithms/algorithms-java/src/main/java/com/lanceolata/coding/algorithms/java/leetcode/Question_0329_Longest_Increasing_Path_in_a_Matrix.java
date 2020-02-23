package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0329_Longest_Increasing_Path_in_a_Matrix {

    private int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int res = 0, m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, help(matrix, dp, i, j));
            }
        }
        return res;
    }

    private int help(int[][] matrix, int[][] dp, int i, int j) {
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        int res = 1, m = matrix.length, n = matrix[0].length;
        for (int[] dir : dirs) {
            int r = i + dir[0], c = j + dir[1];
            if (r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] <= matrix[i][j]) {
                continue;
            }
            res = Math.max(res, help(matrix, dp, r, c) + 1);
        }
        dp[i][j] = res;
        return res;
    }
}
