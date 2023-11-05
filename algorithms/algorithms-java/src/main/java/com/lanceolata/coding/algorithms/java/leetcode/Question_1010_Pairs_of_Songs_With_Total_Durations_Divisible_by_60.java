package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1010_Pairs_of_Songs_With_Total_Durations_Divisible_by_60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] c = new int[60];
        int res = 0;
        for (int t : time) {
            res += c[(600 - t) % 60];
            c[t % 60] += 1;
        }
        return res;
    }
}