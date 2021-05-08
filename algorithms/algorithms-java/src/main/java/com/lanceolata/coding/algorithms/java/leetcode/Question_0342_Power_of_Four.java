package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0342_Power_of_Four {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
    }

    public boolean isPowerOfFour1(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
