package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0482_License_Key_Formatting {
    public String licenseKeyFormatting(String s, int k) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                sb.append(sb.length() % (k + 1) == k ? "-" : "").append(s.charAt(i));
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}
