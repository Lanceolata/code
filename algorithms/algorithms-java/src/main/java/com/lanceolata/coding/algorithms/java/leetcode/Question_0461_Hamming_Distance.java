package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0461_Hamming_Distance {
    public int hammingDistance(int x, int y) {
        x ^= y;
        int res = 0;
        while (x != 0) {
            res++;
            x &= x - 1;
        }
        return res;
    }
}
