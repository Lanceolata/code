package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0344_Reverse_String {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++; j--;
        }
    }
}
