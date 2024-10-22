package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0600_Non_negative_Integers_without_Consecutive_Ones {
    public int findIntegers(int n) {
        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < f.length; i++)
            f[i] = f[i - 1] + f[i - 2];
        int i = 30, sum = 0, prev_bit = 0;
        while (i >= 0) {
            if ((n & (1 << i)) != 0) {
                sum += f[i];
                if (prev_bit == 1) {
                    sum--;
                    break;
                }
                prev_bit = 1;
            } else
                prev_bit = 0;
            i--;
        }
        return sum + 1;
    }
}
