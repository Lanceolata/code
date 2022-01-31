package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0633_Sum_of_Square_Numbers {
    public boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            long j = c - i * i;
            if (help(0, j, j)) {
                return true;
            }
        }
        return false;
    }

    private boolean help(long l, long r, long n) {
        long m, t;
        while (l <= r) {
            m = l + (r - l) / 2;
            t = m * m;
            if (t == n) {
                return true;
            }
            if (t < n) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }

    public boolean judgeSquareSum_fermat(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0) {
                    return false;
                }
            }
        }
        return c % 4 != 3;
    }
}
