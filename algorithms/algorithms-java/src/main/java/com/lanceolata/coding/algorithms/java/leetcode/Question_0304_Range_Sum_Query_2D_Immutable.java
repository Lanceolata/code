package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0304_Range_Sum_Query_2D_Immutable {
    private int[][] sums;

    public Question_0304_Range_Sum_Query_2D_Immutable(int[][] matrix) {
        if (matrix != null && matrix.length != 0) {
            int m = matrix.length, n = matrix[0].length;
            sums = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row2 + 1][col1] - sums[row1][col2 + 1] + sums[row1][col1];
    }
}
