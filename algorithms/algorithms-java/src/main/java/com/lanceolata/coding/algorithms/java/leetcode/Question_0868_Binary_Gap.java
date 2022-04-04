package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0868_Binary_Gap {
    public int binaryGap(int n) {
        int res = 0, cur = -1;
        while (n != 0) {
            if (cur >= 0 || (n & 1) != 0) {
                cur++;
                if ((n & 1) != 0) {
                    res = Math.max(res, cur);
                    cur = 0;
                }
            }
            n >>= 1;
        }
        return res;
    }
}
