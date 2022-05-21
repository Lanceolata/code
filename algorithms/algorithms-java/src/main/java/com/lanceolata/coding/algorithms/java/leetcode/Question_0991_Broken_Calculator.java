package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0991_Broken_Calculator {
    public int brokenCalc(int startValue, int target) {
        int res = 0;
        while (target > startValue) {
            res++;
            if (target % 2 == 1) {
                target++;
            } else {
                target /= 2;
            }
        }
        return res + startValue - target;
    }
}
