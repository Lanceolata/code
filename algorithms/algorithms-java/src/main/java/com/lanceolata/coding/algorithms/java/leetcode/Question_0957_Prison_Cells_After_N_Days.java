package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0957_Prison_Cells_After_N_Days {
    public int[] prisonAfterNDays(int[] cells, int n) {
        for (n = (n - 1) % 14 + 1; n > 0; --n) {
            int[] cells2 = new int[8];
            for (int i = 1; i < 7; ++i) {
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            cells = cells2;
        }
        return cells;
    }
}
