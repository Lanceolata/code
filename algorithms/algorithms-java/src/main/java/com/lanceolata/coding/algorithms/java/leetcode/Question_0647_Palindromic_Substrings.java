package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0647_Palindromic_Substrings {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += extendPalindrome(s, i, i);
            res += extendPalindrome(s, i, i + 1);
        }
        return res;
    }

    private int extendPalindrome(String s, int l, int r) {
        int res = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            res++;
            l--;
            r++;
        }
        return res;
    }
}
