package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0052_N_Queens_II {
    private int res;
    public int totalNQueens(int n) {
        res = 0;
        if (n <= 0) {
            return res;
        }
        boolean[] col = new boolean[n], main = new boolean[2 * n - 1], anti = new boolean[2 * n - 1];
        help(n, 0, col, main, anti);
        return res;
    }

    private void help(int n, int r, boolean[] col, boolean[] main, boolean[] anti) {
        if (r >= n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] || main[r + i] || anti[r + n - 1 - i]) {
                continue;
            }
            col[i] = main[r + i] = anti[r + n - 1 - i] = true;
            help(n, r + 1, col, main, anti);
            col[i] = main[r + i] = anti[r + n - 1 - i] = false;
        }
    }
}
