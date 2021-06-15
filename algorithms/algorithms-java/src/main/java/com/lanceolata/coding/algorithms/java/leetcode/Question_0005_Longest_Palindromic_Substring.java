package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0005_Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        if (s == null) {
            return s;
        }
        int[] record = {0, 0};
        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i, record);
            expandAroundCenter(s, i, i + 1, record);
        }
        // 注意 substring 方法的参数
        return s.substring(record[0], record[0] + record[1]);
    }

    private void expandAroundCenter(String s, int l, int r, int[] record) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (r - l - 1 > record[1]) {
            record[0] = l + 1;
            record[1] = r - l - 1;
        }
    }
}
