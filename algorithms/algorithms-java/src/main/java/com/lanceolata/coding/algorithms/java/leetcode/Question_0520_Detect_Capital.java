package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0520_Detect_Capital {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        int up = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                up++;
            }
        }
        return up == 0 || up == word.length() || (up == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
