package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1016_Binary_String_With_Substrings_Representing_1_To_N {
    public boolean queryString(String s, int n) {
        for (int i = n; i > n / 2; --i) {
            if (!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }
}
