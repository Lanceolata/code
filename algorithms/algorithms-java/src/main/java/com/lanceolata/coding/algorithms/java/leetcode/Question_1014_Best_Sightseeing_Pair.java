package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1014_Best_Sightseeing_Pair {
    public int maxScoreSightseeingPair(int[] values) {
        int res = 0, cur = 0;
        for (int v : values) {
            res = Math.max(res, cur + v);
            cur = Math.max(cur, v) - 1;
        }
        return res;
    }
}
