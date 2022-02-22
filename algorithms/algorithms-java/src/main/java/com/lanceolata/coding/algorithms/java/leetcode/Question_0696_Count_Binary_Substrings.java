package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0696_Count_Binary_Substrings {
    public int countBinarySubstrings(String s) {
        int res = 0, pre = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                res += Math.min(pre, cur);
                pre = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return res + Math.min(pre, cur);
    }
}
