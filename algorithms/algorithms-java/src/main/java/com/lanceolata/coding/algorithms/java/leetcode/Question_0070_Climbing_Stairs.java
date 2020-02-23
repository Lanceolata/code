package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0070_Climbing_Stairs {
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 1, second = 1, third;
        for (int i = 2; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
