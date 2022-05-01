package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Question_0934_Shortest_Bridge {
    private static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < m && !found; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, queue, i, j);
                    found = true;
                    break;
                }
            }
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int i = cur[0] + dir[0];
                    int j = cur[1] + dir[1];
                    if (i >= 0 && j >= 0 && i < m && j < n && !visited[i][j]) {
                        if (grid[i][j] == 1) {
                            return step;
                        }
                        queue.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private void dfs(int[][] A, boolean[][] visited, Queue<int[]> queue, int i, int j) {
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || visited[i][j] || A[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        for (int[] dir : dirs) {
            dfs(A, visited, queue, i + dir[0], j + dir[1]);
        }
    }
}
