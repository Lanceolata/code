package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0171_Excel_Sheet_Column_Number {
    public int titleToNumber(String columnTitle) {
        if (columnTitle == null) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            res = res * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return res;
    }
}
