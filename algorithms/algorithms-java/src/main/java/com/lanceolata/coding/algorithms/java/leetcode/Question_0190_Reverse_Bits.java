package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0190_Reverse_Bits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n >> i) & 1;
        }
        return res;
    }
}
