package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0172_Factorial_Trailing_Zeroes {
    public int trailingZeroesRecursive(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroesRecursive(n / 5);
    }

    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
