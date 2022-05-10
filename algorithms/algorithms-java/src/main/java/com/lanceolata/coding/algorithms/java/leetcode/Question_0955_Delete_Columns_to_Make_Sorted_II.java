package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0955_Delete_Columns_to_Make_Sorted_II {
    public int minDeletionSize(String[] strs) {
        int res = 0, n = strs.length, m = strs[0].length(), i, j;
        boolean[] sorted = new boolean[n - 1];
        for (j = 0; j < m; ++j) {
            for (i = 0; i < n - 1; ++i) {
                if (!sorted[i] && strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    res++;
                    break;
                }
            }
            if (i < n - 1) {
                continue;
            }
            for (i = 0; i < n - 1; ++i) {
                sorted[i] |= strs[i].charAt(j) < strs[i + 1].charAt(j);
            }
        }
        return res;
    }
}
