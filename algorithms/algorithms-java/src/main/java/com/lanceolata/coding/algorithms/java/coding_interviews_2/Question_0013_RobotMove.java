package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0013_RobotMove {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        return help(threshold, rows, cols, 0, 0, visited);
    }

    private int help(int threshold, int rows, int cols, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return 0;
        }
        if (visited[r][c] || count(r) + count(c) > threshold) {
            return 0;
        }
        visited[r][c] = true;
        int res = 1;
        res += help(threshold, rows, cols, r - 1, c, visited);
        res += help(threshold, rows, cols, r + 1, c, visited);
        res += help(threshold, rows, cols, r , c - 1, visited);
        res += help(threshold, rows, cols, r, c + 1, visited);
        return res;
    }

    private int count(int n) {
        int res = 0;
        while (n != 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}
