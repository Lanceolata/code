package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0066_Plus_One {
    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
