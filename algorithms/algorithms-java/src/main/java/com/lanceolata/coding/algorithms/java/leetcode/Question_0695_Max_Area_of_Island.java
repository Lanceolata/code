package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0695_Max_Area_of_Island {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || grid[i][j] == 0) {
                    continue;
                }
                res = Math.max(res, help(grid, i, j, visited));
            }
        }
        return res;
    }

    private int help(int[][] grid, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return 0;
        }
        if (visited[r][c] || grid[r][c] == 0) {
            return 0;
        }
        visited[r][c] = true;
        int res = 1;
        res += help(grid, r - 1, c, visited);
        res += help(grid, r + 1, c, visited);
        res += help(grid, r, c - 1, visited);
        res += help(grid, r, c + 1, visited);
        return res;
    }
}
