package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0409_Longest_Palindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] counts = new int[256];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)]++;
        }
        int res = 0;
        for (int i : counts) {
            res += i / 2 * 2;
        }
        return res == s.length() ? res : res + 1;
    }
}
