package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0214_Shortest_Palindrome {
    public String shortestPalindrome(String s) {
        int l = 0;
        for (int r = s.length() - 1; r >= 0; r--) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
            }
        }
        if (l == s.length()) {
            return s;
        }
        String suffix = s.substring(l);
        return new StringBuilder(suffix).reverse() + shortestPalindrome(s.substring(0, l)) + suffix;
    }
}
