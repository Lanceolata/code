package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0458_Poor_Pigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        while (Math.pow(minutesToTest / minutesToDie + 1, pigs) < buckets) {
            pigs++;
        }
        return pigs;
    }
}
