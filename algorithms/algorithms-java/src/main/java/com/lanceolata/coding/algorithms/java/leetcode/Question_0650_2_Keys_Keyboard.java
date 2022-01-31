package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0650_2_Keys_Keyboard {
    public int minSteps(int n) {
        int res = 0, d = 2;
        while (n > 1) {
            while (n % d == 0) {
                res += d;
                n /= d;
            }
            d++;
        }
        return res;
    }
}
