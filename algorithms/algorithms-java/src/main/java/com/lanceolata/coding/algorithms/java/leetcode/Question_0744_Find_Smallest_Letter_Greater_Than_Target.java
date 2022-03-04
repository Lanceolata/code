package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0744_Find_Smallest_Letter_Greater_Than_Target {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (letters[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return letters[l % letters.length];
    }
}
