package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0521_Longest_Uncommon_Subsequence_I {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
