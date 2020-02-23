package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0005_ReplaceSpaces {
    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        int m = str.length();
        for (int i = m - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int n = str.length();
        for (int i = m - 1, j = n - 1; i >= 0 && j >= 0 && j > i; i--) {
            char c = str.charAt(i);
            if (c == ' ') {
                str.setCharAt(j--, '0');
                str.setCharAt(j--, '2');
                str.setCharAt(j--, '%');
            } else {
                str.setCharAt(j--, c);
            }
        }
        return str.toString();
    }
}
