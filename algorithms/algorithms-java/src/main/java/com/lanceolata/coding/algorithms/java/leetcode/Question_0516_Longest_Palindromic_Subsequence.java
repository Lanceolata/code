package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0516_Longest_Palindromic_Subsequence {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length(), res = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = n - 1; i >= 0; --i) {
            int len = 0;
            for (int j = i + 1; j < n; ++j) {
                int t = dp[j];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = len + 2;
                }
                len = Math.max(len, t);
            }
        }
        for (int num : dp) {
            res = Math.max(res, num);
        }
        return res;
    }
}
