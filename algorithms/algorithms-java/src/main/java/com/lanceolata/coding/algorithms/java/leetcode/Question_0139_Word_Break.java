package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.List;

public class Question_0139_Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null) {
            return false;
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = i; dp[i] && j < n; j++) {
                if (wordDict.contains(s.substring(i, j + 1))) {
                    dp[j + 1] = true;
                }
            }
        }
        return dp[n];
    }
}
