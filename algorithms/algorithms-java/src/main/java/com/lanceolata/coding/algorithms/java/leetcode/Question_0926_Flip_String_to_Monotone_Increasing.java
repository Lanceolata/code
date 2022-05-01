package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0926_Flip_String_to_Monotone_Increasing {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            dp[i + 1] = dp[i] + (s.charAt(i) == '1' ? 1 : 0);
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j <= n; ++j) {
            res = Math.min(res, dp[j] + n - j - (dp[n] - dp[j]));
        }
        return res;
    }
}
