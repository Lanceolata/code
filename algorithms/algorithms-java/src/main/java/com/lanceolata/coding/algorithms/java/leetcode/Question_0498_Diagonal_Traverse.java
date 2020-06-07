package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0498_Diagonal_Traverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length, k = 0;
        int[] res = new int[m * n];
        for (int i = 0; i < m + n - 1; i++) {
            int low = Math.max(0, i - n + 1), high = Math.min(i, m - 1);
            if (i % 2 == 0) {
                for (int j = high; j >= low; --j) {
                    res[k++] = matrix[j][i - j];
                }
            } else {
                for (int j = low; j <= high; ++j) {
                    res[k++] = matrix[j][i - j];
                }
            }
        }
        return res;
    }
}
