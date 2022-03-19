package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0807_Max_Increase_to_Keep_City_Skyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowMaxes = new int[n], colMaxes = new int[n];
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                rowMaxes[r] = Math.max(rowMaxes[r], grid[r][c]);
                colMaxes[c] = Math.max(colMaxes[c], grid[r][c]);
            }
        }
        int res = 0;
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                res += Math.min(rowMaxes[r], colMaxes[c]) - grid[r][c];
            }
        }
        return res;
    }
}
