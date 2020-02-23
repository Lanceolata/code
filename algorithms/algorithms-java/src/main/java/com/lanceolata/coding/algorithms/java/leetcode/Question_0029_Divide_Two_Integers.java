package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0029_Divide_Two_Integers {
    public int divide(int dividend, int divisor) {
        // 注意类型转换
        long m = Math.abs((long)dividend), n = Math.abs((long)divisor), res = 0;
        if (m < n) {
            return 0;
        }
        while (m >= n) {
            long t = n, p = 1;
            while (m >= (t << 1)) {
                t <<= 1;
                p <<= 1;
            }
            res += p;
            m -= t;
        }
        // 注意符号处理
        if ((dividend < 0) ^ (divisor < 0)) {
            res = -res;
        }
        // 注意边界值判断
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)res;
    }
}
