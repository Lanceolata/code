package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0482_License_Key_Formatting {
    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                sb.append(sb.length() % (K + 1) == K ? '-' : "").append(S.charAt(i));
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}
