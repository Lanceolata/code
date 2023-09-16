package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1020_Number_of_Enclaves {
    public int numEnclaves(int[][] grid) {
        int res = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int r = 1; r < grid.length - 1; r++) {
            for (int c = 1; c < grid[0].length - 1; c++) {
                int v = help(grid, r, c, visited);
                if (v > 0) {
                    System.out.println(r + "\t" + c + "\t" + v);
                    res += v;
                }
            }
        }
        return res;
    }

    private int help(int[][] grid, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return -1;
        }
        if (visited[r][c] || grid[r][c] == 0) {
            return 0;
        }
        visited[r][c] = true;
        int v1 = help(grid, r + 1, c, visited);
        int v2 = help(grid, r - 1, c, visited);
        int v3 = help(grid, r, c + 1, visited);
        int v4 = help(grid, r, c - 1, visited);
        if (v1 < 0 || v2 < 0 || v3 < 0 || v4 < 0) {
            return -1;
        }
        return v1 + v2 + v3 + v4 + 1;
    }
}
