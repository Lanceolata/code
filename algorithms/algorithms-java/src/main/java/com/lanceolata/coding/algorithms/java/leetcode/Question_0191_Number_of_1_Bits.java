package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0191_Number_of_1_Bits {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
}
