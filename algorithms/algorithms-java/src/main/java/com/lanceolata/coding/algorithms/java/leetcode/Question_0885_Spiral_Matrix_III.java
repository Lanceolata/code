package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0885_Spiral_Matrix_III {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] res = new int[rows * cols][2];
        res[0] = new int[]{rStart, cStart};
        int dx = 0, dy = 1, tmp, j = 1;
        for (int n = 0; j < rows * cols; n++) {
            for (int i = 0; i < n / 2 + 1; i++) {
                rStart += dx;
                cStart += dy;
                if (0 <= rStart && rStart < rows && 0 <= cStart && cStart < cols) {
                    res[j++] = new int[]{rStart, cStart};
                }
            }
            tmp = dx;
            dx = dy;
            dy = -tmp;
        }
        return res;
    }
}
