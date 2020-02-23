package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0306_Additive_Number {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.isEmpty()) {
            return false;
        }
        int n = num.length();
        for (int i = 1; i <= n / 2; ++i) {
            for (int j = 1; Math.max(j, i) <= n - i - j; ++j) {
                if (isValid(num, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(String num, int i, int j) {
        // make sure an at least two digit number does not start with 0
        if (num.charAt(0) == '0' && i > 1) {
            return false;
        }
        if (num.charAt(i) == '0' && j > 1) {
            return false;
        }
        String sum;
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 = x2 + x1;
            x1 = x2 - x1;
            sum = x2.toString();
            if (!num.startsWith(sum, start)) {
                return false;
            }
        }
        return true;
    }
}
