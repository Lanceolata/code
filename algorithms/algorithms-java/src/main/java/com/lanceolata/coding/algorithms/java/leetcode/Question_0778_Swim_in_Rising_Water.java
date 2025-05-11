package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0778_Swim_in_Rising_Water {

    private boolean[][] visited;
    private int[] DIR = {0, 1, 0, -1, 0};

    public int swimInWater(int[][] grid) {
        int n = grid.length, i = 0, j = 50 * 50 + 1;
        while (i < j) {
            visited = new boolean[n][n];
            int mid = i + (j - i) / 2;
            if (mid >= grid[0][0] && dfs(grid, 0, 0, mid)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return j;
    }

    private boolean dfs(int[][] grid, int x, int y, int threshold) {
        visited[x][y] = true;
        if (x == grid.length - 1 && y == grid.length - 1) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + DIR[i], ny = y + DIR[i + 1];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && !visited[nx][ny] && grid[nx][ny] <= threshold && dfs(grid, nx, ny, threshold)) {
                return true;
            }
        }

        return false;
    }
}
