package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0079_Word_Search {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (help(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean help(char[][] board, String word, int r, int c, int i, boolean[][] visited) {
        if (i >= word.length()) {
            return true;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return false;
        }
        if (visited[r][c] || board[r][c] != word.charAt(i)) {
            return false;
        }
        visited[r][c] = true;
        if (help(board, word, r + 1, c, i + 1, visited) || help(board, word, r - 1, c, i + 1, visited)
                || help(board, word, r, c + 1, i + 1, visited) || help(board, word, r, c - 1, i + 1, visited)) {
            return true;
        }
        visited[r][c] = false;
        return false;
    }
}
