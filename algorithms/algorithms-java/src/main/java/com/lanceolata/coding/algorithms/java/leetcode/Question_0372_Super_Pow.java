package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0372_Super_Pow {

    private static final int base = 1337;

    public int superPow(int a, int[] b) {
        if (a == 0 || b == null) {
            return 0;
        }
        int res = 1;
        for (int i = 0; i < b.length; i++) {
            res = powmod(res, 10) * powmod(a, b[i]) % base;
        }
        return res;
    }

    int powmod(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int t = powmod(x, n >> 1) % base;
        if ((n & 1) == 1) {
            t = (x % base) * ((t * t) % base) % base;
        } else {
            t = (t * t) % base;
        }
        return t;
    }
}
