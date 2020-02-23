package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0326_Power_of_Three {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
