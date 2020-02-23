package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0058_Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        int res = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--; res++;
        }
        return res;
    }
}
