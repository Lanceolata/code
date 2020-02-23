package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0201_Bitwise_AND_of_Numbers_Range {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n &= (n - 1);
        }
        return n;
    }
}
