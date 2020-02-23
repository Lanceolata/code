package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0367_Valid_Perfect_Square {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }

    public boolean isPerfectSquare_dichotomy(int num) {
        if (num < 2) {
            return true;
        }
        long l = 0, r = num / 2, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (m * m == num) {
                return true;
            } else if (m * m < num) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}
