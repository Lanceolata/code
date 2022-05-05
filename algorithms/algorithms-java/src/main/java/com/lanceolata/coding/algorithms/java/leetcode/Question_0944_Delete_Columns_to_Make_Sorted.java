package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0944_Delete_Columns_to_Make_Sorted {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j - 1].charAt(i) > strs[j].charAt(i)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
