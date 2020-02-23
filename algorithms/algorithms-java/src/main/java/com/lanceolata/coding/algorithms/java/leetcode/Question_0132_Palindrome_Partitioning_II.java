package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0132_Palindrome_Partitioning_II {
    public int minCut(String s) {
        if (s == null) {
            return -1;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = -1;
        for (int i = 0; i < n; i++) {
            for (int len = 0; i - len >= 0 && i + len < n && s.charAt(i - len) == s.charAt(i + len); len++) {
                dp[i + len + 1] = Math.min(dp[i + len + 1], dp[i - len] + 1);
            }
            for (int len = 0; i - len >= 0 && i + len + 1 < n && s.charAt(i - len) == s.charAt(i + len + 1); len++) {
                dp[i + len + 2] = Math.min(dp[i + len + 2], dp[i - len] + 1);
            }
        }
        return dp[n];
    }
}
