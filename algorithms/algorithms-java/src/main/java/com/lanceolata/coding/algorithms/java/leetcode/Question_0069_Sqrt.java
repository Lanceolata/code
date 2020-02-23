package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0069_Sqrt {
    public int mySqrt(int x) {
        long res = x, raw = x;
        while (res * res > raw) {
            res = (res + raw / res) / 2;
        }
        return (int) res;
    }

    public int mySqrt2(int x) {
        if (x < 0) {
            return -1;
        }
        long l = 0, r = x, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (m * m > x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return (int) r;
    }
}
