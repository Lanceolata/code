package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0566_Reshape_the_Matrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c || (m == r && n == c)) {
            return mat;
        }
        int[][] res = new int[r][c];
        int rr = 0, cc = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[rr][cc++] = mat[i][j];
                if (cc >= c) {
                    rr++;
                    cc = 0;
                }
            }
        }
        return res;
    }
}
