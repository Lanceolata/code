package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0188_Best_Time_to_Buy_and_Sell_Stock_IV {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        //if k >= n/2, then you can make maximum number of transactions.
        if (k >= n / 2) {
            int res = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    res += prices[i] - prices[i - 1];
                }
            }
            return res;
        }

        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }
}
