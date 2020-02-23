package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0397_Integer_Replacement {
    int integerReplacement(int n) {
        long t = n;
        int cnt = 0;
        while (t > 1) {
            ++cnt;
            if ((t & 1) != 0) {
                if ((t & 2) != 0 && t != 3) {
                    ++t;
                } else {
                    --t;
                }
            } else {
                t >>= 1;
            }
        }
        return cnt;
    }
}
