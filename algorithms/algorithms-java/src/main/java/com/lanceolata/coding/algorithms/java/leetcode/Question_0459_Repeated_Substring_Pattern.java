package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0459_Repeated_Substring_Pattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);
    }
}
