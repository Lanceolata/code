package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0799_Champagne_Tower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glass = new double[102][102];
        glass[0][0] = (double) poured;
        for (int r = 0; r <= query_row; ++r) {
            for (int c = 0; c <= r; ++c) {
                double q = (glass[r][c] - 1.0) / 2.0;
                if (q > 0) {
                    glass[r + 1][c] += q;
                    glass[r + 1][c + 1] += q;
                }
            }
        }
        return Math.min(1, glass[query_row][query_glass]);
    }
}
