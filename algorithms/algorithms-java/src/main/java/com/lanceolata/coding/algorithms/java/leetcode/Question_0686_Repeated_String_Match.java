package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0686_Repeated_String_Match {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder s = new StringBuilder(a);
        for (int i = 1; i <= b.length() / a.length() + 2; i++, s.append(a)) {
            if (s.indexOf(b) != -1) {
                return i;
            }
        }
        return -1;
    }
}
