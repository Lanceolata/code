package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0392_Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int i = 0, j = 0;
        for (; i < s.length() && j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        return i >= s.length();
    }
}
