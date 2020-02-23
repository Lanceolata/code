package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0342_Power_of_Four {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
