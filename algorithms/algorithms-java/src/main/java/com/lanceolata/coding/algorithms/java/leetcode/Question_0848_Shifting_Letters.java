package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0848_Shifting_Letters {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder res = new StringBuilder(s);
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        }
        for (int i = 0; i < s.length(); i++) {
            res.setCharAt(i, (char) ((s.charAt(i) - 'a' + shifts[i]) % 26 + 'a'));
        }
        return res.toString();
    }
}
