package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0338_Counting_Bits {
    public int[] countBits(int n) {
        if (n < 0) {
            return new int[0];
        }
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
