package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Question_1030_Matrix_Cells_in_Distance_Order {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] origin = new int[rows * cols][2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                origin[i * cols + j] = new int[]{i, j};
            }
        }

        Arrays.sort(origin, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter)
                        - Math.abs(b[0] - rCenter) - Math.abs(b[1] - cCenter);
            }
        });
        return origin;
    }

    public int[][] allCellsDistOrder_bfs(int rows, int cols, int rCenter, int cCenter) {
        boolean[][] visited = new boolean[rows][cols];
        int[][] result = new int[rows * cols][2];
        int i = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{rCenter, cCenter});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            if (r < 0 || r >= rows || c < 0 || c >= cols) {
                continue;
            }
            if (visited[r][c]) {
                continue;
            }

            result[i] = cell;
            i++;
            visited[r][c] = true;

            queue.offer(new int[]{r, c - 1});
            queue.offer(new int[]{r, c + 1});
            queue.offer(new int[]{r - 1, c});
            queue.offer(new int[]{r + 1, c});
        }
        return result;
    }
}
