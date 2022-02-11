package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0670_Maximum_Swap {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int maxIdx = -1, leftIdx = -1, rightIdx = -1;
        char maxDigit = '0' - 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] > maxDigit) {
                maxIdx = i;
                maxDigit = digits[i];
                continue;
            }
            if (digits[i] < maxDigit) {
                leftIdx = i;
                rightIdx = maxIdx;
            }
        }
        if (leftIdx == -1) {
            return num;
        }
        char tmp = digits[leftIdx];
        digits[leftIdx] = digits[rightIdx];
        digits[rightIdx] = tmp;
        return Integer.parseInt(new String(digits));
    }
}
