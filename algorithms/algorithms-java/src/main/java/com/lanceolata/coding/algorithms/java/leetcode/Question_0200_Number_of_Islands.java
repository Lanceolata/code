package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0200_Number_of_Islands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length, res = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (help(grid, i, j, visited)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean help(char[][] grid, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return false;
        }
        if (grid[r][c] != '1' || visited[r][c]) {
            return false;
        }
        visited[r][c] = true;
        help(grid, r - 1, c, visited);
        help(grid, r + 1, c, visited);
        help(grid, r, c - 1, visited);
        help(grid, r, c + 1, visited);
        return true;
    }
}
