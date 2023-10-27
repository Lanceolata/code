package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1049_Last_Stone_Weight_II {
    public int lastStoneWeightII(int[] stones) {
        boolean[] dp = new boolean[1501];
        dp[0] = true;
        int sum = 0;
        for (int s : stones) {
            sum += s;
            for (int i = Math.min(1500, sum); i >= s; --i) {
                dp[i] |= dp[i - s];
            }
        }
        for (int i = sum / 2; i >= 0; --i) {
            if (dp[i]) {
                return sum - i - i;
            }
        }
        return 0;
    }
}
