package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0746_Min_Cost_Climbing_Stairs {
    public int minCostClimbingStairs(int[] cost) {
        int s1 = 0, s2 = 0, t;
        for (int c : cost) {
            t = Math.min(s1, s2) + c;
            s2 = s1;
            s1 = t;
        }
        return Math.min(s1, s2);
    }
}
