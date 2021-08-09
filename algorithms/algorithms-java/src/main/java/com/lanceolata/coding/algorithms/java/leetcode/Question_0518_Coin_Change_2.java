package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0518_Coin_Change_2 {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                dp[i] += dp[i - c];
            }
        }
        return dp[amount];
    }
}
