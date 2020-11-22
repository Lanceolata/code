package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0010_Regular_Expression_Matching {
    public boolean isMatch(String s, String p) {
        if (p == null) {
            return s == null;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        for (int i = s.length(); i>= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (match && dp[i + 1][j]);
                } else {
                    dp[i][j] = match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public boolean isMatch_recursion(String s, String p) {
        if (s == null) {
            return p == null;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        }
        return help(s, p, 0, 0);
    }

    private boolean help(String s, String p, int i, int j) {
        // 注意，使用j判断
        if (j >= p.length()) {
            return i >= s.length();
        }
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            return (match && help(s, p, i + 1, j)) || help(s, p, i, j + 2);
        } else {
            return match && help(s, p, i + 1, j + 1);
        }
    }
}
