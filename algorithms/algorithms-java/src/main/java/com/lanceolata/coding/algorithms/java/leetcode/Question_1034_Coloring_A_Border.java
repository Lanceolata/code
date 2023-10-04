package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1034_Coloring_A_Border {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        if (grid[row][col] == color) {
            return grid;
        }
        boolean[][] visited = new boolean[m][n];
        dfs(grid, row, col, grid[row][col], visited, color);
        return grid;
    }

    private void dfs(int[][] grid, int r, int c, int color, boolean[][] visited, int target) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return;
        }
        if (grid[r][c] != color || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        boolean border = false;
        if (r == 0 || r == grid.length - 1 || c == 0 || c == grid[0].length - 1
                || grid[r + 1][c] != color || grid[r - 1][c] != color
                || grid[r][c - 1] != color || grid[r][c + 1] != color) {
            border = true;
        }

        dfs(grid, r + 1, c, color, visited, target);
        dfs(grid, r - 1, c, color, visited, target);
        dfs(grid, r, c + 1, color, visited, target);
        dfs(grid, r, c - 1, color, visited, target);

        if (border) {
            grid[r][c] = target;
        }
    }
}
