package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0201_Bitwise_AND_of_Numbers_Range {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right &= (right - 1);
        }
        return right;
    }
}
