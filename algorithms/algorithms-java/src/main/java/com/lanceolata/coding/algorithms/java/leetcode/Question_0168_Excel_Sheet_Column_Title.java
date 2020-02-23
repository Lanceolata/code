package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0168_Excel_Sheet_Column_Title {
    public String convertToTitleRecursive(int n) {
        return n == 0 ? "" : convertToTitleRecursive(--n / 26) + (char) ('A' + (n % 26));
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            char c = (char) ((n - 1) % 26 + 'A');
            sb.append(c);
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();
    }
}
