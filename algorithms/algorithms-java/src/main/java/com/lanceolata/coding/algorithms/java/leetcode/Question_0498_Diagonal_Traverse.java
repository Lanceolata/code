package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0498_Diagonal_Traverse {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0) {
            return new int[0];
        }
        int m = mat.length, n = mat[0].length, k = 0;
        int[] res = new int[m * n];
        for (int i = 0; i < m + n - 1; i++) {
            int low = Math.max(0, i - n + 1), high = Math.min(i, m - 1);
            if (i % 2 == 0) {
                for (int j = high; j >= low; --j) {
                    res[k++] = mat[j][i - j];
                }
            } else {
                for (int j = low; j <= high; ++j) {
                    res[k++] = mat[j][i - j];
                }
            }
        }
        return res;
    }
}
