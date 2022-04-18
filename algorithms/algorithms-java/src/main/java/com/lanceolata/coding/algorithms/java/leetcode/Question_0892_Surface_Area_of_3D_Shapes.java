package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0892_Surface_Area_of_3D_Shapes {
    public int surfaceArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    sum += grid[i][j] * 4 + 2;
                }
                if (i > 0) {
                    sum -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                }
                if (j > 0) {
                    sum -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
                }
            }
        }
        return sum;
    }
}
