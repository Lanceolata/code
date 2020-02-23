package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0044_DigitsInSequence {
    public int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        int digits = 1;
        for (;; digits++) {
            int nums = count(digits);
            if (index < nums * digits) {
                break;
            }
            index -= nums * digits;
        }
        int number = begin(digits) + index / digits;
        int indexFromRight = digits - index % digits;
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
