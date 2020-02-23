package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0059_Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return null;
        }
        int[][] res = new int[n][n];
        int rStart = 0, rEnd = n - 1, cStart = 0, cEnd = n - 1, v = 1;
        while (rStart <= rEnd && cStart <= cEnd) {
            for (int j = cStart; j <= cEnd; j++) {
                res[rStart][j] = v++;
            }
            for (int i = rStart + 1; i <= rEnd; i++) {
                res[i][cEnd] = v++;
            }
            for (int j = cEnd - 1; j >= cStart; j--) {
                res[rEnd][j] = v++;
            }
            for (int i = rEnd - 1; i > rStart; i--) {
                res[i][cStart] = v++;
            }
            rStart++; rEnd--; cStart++; cEnd--;
        }
        return res;
    }
}
