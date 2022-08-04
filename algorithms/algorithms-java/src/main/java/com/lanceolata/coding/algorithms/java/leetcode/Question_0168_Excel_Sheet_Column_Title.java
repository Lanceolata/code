package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0168_Excel_Sheet_Column_Title {
    public String convertToTitleRecursive(int columnNumber) {
        return columnNumber == 0 ? "" : convertToTitleRecursive(--columnNumber / 26) + (char) ('A' + (columnNumber % 26));
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            char c = (char) ((columnNumber - 1) % 26 + 'A');
            sb.append(c);
            columnNumber = (columnNumber - 1) / 26;
        }
        return sb.reverse().toString();
    }
}
