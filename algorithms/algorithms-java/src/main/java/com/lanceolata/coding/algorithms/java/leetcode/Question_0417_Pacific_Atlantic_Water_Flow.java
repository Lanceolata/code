package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0417_Pacific_Atlantic_Water_Flow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n], atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int pre, int r, int c) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length) {
            return;
        }
        if (visited[r][c] || matrix[r][c] < pre) {
            return;
        }
        visited[r][c] = true;
        dfs(matrix, visited, matrix[r][c], r - 1, c);
        dfs(matrix, visited, matrix[r][c], r + 1, c);
        dfs(matrix, visited, matrix[r][c], r, c - 1);
        dfs(matrix, visited, matrix[r][c], r, c + 1);
    }
}
