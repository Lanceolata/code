package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0051_N_Queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        boolean[] col = new boolean[n], main = new boolean[2 * n - 1], anti = new boolean[2 * n - 1];
        help(n, 0, board, col, main, anti, res);
        return res;
    }

    private void help(int n, int r, char[][] board, boolean[] col, boolean[] main, boolean[] anti, List<List<String>> res) {
        if (r >= n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] || main[r + i] || anti[r + n - 1 - i]) {
                continue;
            }
            col[i] = main[r + i] = anti[r + n - 1 - i] = true;
            board[r][i] = 'Q';
            help(n, r + 1, board, col, main, anti, res);
            col[i] = main[r + i] = anti[r + n - 1 - i] = false;
            board[r][i] = '.';
        }
    }
}
