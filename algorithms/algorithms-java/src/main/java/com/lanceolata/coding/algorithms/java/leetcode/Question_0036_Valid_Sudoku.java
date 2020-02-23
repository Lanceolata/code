package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0036_Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], area = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                // 注意要 * 3
                int k = i / 3 * 3 + j / 3;
                int n = board[i][j] - '1';
                if (row[i][n] || col[j][n] || area[k][n]) {
                    return false;
                }
                row[i][n] = col[j][n] = area[k][n] = true;
            }
        }
        return true;
    }
}
