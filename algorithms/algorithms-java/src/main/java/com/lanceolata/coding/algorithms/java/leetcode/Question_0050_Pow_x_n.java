package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0050_Pow_x_n {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / x * myPow(1 / x, -(n + 1));
        } else if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        }
        double half = myPow(x, n >> 1);
        half *= half;
        if ((n & 1) == 1) {
            half *= x;
        }
        return half;
    }
}
