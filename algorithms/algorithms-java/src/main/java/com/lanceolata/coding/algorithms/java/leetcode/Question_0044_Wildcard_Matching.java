package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0044_Wildcard_Matching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int i = 0, j = 0, start = -1, match = -1;
        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                start = j;
                match = i;
                j++;
            } else if (start != -1) {
                j = start + 1;
                match++;
                i = match;
            } else {
                return false;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }
}
