package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0994_Rotting_Oranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] vec = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vec[i][j] = -1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    bfs(grid, i, j, 0, vec);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vec[i][j] <= 0) {
                    return -1;
                }
                res = Math.max(res, vec[i][j]);
            }
        }
        return res;
    }

    private void bfs(int[][] grid, int r, int c, int n, int[][] vec) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return;
        }
        if (vec[r][c] >= 0 && vec[r][c] <= n) {
            return;
        }
        vec[r][c] = n;
        bfs(grid, r - 1, c, n + 1, vec);
        bfs(grid, r + 1, c, n + 1, vec);
        bfs(grid, r, c - 1, n + 1, vec);
        bfs(grid, r, c + 1, n + 1, vec);
    }
}
