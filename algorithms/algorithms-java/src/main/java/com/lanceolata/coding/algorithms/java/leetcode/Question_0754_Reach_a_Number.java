package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0754_Reach_a_Number {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            target -= ++k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }
}
