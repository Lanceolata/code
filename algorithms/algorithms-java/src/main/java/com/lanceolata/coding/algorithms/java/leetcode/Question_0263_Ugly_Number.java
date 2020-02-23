package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0263_Ugly_Number {
    public boolean isUgly(int num) {
        for (int i = 5; i >= 2 && num > 0; i--) {
            while (num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }
}
