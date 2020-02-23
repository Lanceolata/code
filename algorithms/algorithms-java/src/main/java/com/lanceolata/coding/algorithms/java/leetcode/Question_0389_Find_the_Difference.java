package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0389_Find_the_Difference {
    public char findTheDifference(String s, String t) {
        int count = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            count -= s.charAt(i);
            count += t.charAt(i);
        }
        return (char)count;
    }
}
