package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0529_Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int row = click[0], col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    int x = row + i, y = col + j;
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    if (board[x][y] == 'M') {
                        count++;
                    }
                }
            }
            if (count > 0) {
                board[row][col] = (char) (count + '0');
            } else {
                board[row][col] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        int x = row + i, y = col + j;
                        if (x < 0 || x >= m || y < 0 || y >= n) {
                            continue;
                        }
                        if (board[x][y] == 'E') {
                            int[] next = {x, y};
                            updateBoard(board, next);
                        }
                    }
                }
            }
        }
        return board;
    }
}
