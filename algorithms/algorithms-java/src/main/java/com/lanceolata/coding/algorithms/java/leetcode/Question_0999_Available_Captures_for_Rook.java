package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0999_Available_Captures_for_Rook {
    public int numRookCaptures(char[][] board) {
        int r = 0, c = 0, res = 0;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == 'R') {
                    r = i;
                    c = j;
                }
            }
        }
        for (int[] d : new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}) {
            for (int x = r + d[0], y = c + d[1]; 0 <= x && x < 8 && 0 <= y && y < 8; x += d[0], y += d[1]) {
                if (board[x][y] == 'p') {
                    res++;
                }
                if (board[x][y] != '.') {
                    break;
                }
            }
        }
        return res;
    }
}
