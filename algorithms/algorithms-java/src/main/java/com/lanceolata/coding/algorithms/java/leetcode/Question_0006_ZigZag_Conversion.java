package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0006_ZigZag_Conversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) {
            return s;
        }
        int lag = 2 * (numRows - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += lag) {
                sb.append(s.charAt(j));
                if (i != 0 && i != numRows - 1) {
                    int n = j + lag - 2 * i;
                    if (n < s.length()) {
                        sb.append(s.charAt(n));
                    }
                }
            }
        }
        return sb.toString();
    }
}
