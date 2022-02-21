package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0688_Knight_Probability_in_Chessboard {
    public double knightProbability(int n, int k, int row, int column) {
        double[][] dp = new double[n][n];
        int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
        int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};
        dp[row][column] = 1;
        for (; k > 0; k--) {
            double[][] dp2 = new double[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    for (int i = 0; i < 8; i++) {
                        int cr = r + dr[i];
                        int cc = c + dc[i];
                        if (0 <= cr && cr < n && 0 <= cc && cc < n) {
                            dp2[cr][cc] += dp[r][c] / 8.0;
                        }
                    }
                }
            }
            dp = dp2;
        }
        double res = 0.0;
        for (double[] r: dp) {
            for (double x: r) {
                res += x;
            }
        }
        return res;
    }
}
