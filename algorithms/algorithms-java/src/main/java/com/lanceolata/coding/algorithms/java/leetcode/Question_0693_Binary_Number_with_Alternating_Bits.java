package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0693_Binary_Number_with_Alternating_Bits {
    public boolean hasAlternatingBits(int n) {
        while (n > 0) {
            if ((n & 1) == ((n >> 1) & 1)) {
                return false;
            }
            n >>= 1;
        }
        return true;
    }
}
