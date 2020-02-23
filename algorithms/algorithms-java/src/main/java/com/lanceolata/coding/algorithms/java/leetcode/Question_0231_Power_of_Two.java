package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0231_Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
