package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0400_Nth_Digit {
    public int findNthDigit(int n) {
        if (n < 0) {
            return -1;
        }
        int digits = 1;
        for (;; digits++) {
            int nums = count(digits);
            if ((long)n < (long)nums * digits) {
                break;
            }
            n -= nums * digits;
        }
        int number = begin(digits) + n / digits;
        int indexFromRight = digits - n % digits;
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    private int count(int n) {
        if (n == 1) {
            return 10;
        }
        return 9 * (int)Math.pow(10, n - 1);
    }

    private int begin(int n) {
        if (n == 1) {
            return 0;
        }
        return (int)Math.pow(10, n - 1);
    }
}
