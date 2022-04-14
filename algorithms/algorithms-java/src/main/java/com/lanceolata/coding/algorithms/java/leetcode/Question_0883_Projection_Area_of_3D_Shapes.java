package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0883_Projection_Area_of_3D_Shapes {
    public int projectionArea(int[][] grid) {
        int n = grid.length, res = 0;
        for (int i = 0; i < n; ++i) {
            int row = 0, col = 0;
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    res++;
                }
                row = Math.max(row, grid[i][j]);
                col = Math.max(col, grid[j][i]);
            }
            res += row + col;
        }
        return res;
    }
}
