package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0880_Decoded_String_at_Index {
    public String decodeAtIndex(String s, int k) {
        long size = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                size *= c - '0';
            } else {
                size++;
            }
        }
        String res = null;
        for (int i = n - 1; i >= 0; --i) {
            k %= size;
            char c = s.charAt(i);
            if (k == 0 && Character.isLetter(c)) {
                res = Character.toString(c);
                break;
            }
            if (Character.isDigit(c)) {
                size /= c - '0';
            } else {
                size--;
            }
        }
        return res;
    }
}
