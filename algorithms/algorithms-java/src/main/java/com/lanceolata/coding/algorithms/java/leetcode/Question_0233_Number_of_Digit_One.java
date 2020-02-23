package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0233_Number_of_Digit_One {
    public int countDigitOne(int n) {
        long res = 0;
        for (long i = 1; i <= n; i *= 10) {
            long low = n % i;
            long cur = (n / i) % 10;
            long high = n / (i * 10);
            if (cur == 0) {
                res += high * i;
            } else if (cur == 1) {
                res += high * i + low + 1;
            } else {
                res += (high + 1) * i;
            }
        }
        return (int) res;
    }
}
