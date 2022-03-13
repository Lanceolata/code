package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0787_Cheapest_Flights_Within_K_Stops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dp = new int[n];
        int val = (int) 1e8;
        Arrays.fill(dp, val);
        dp[src] = 0;
        for (int i = 0; i <= k; ++i) {
            int[] t = new int[n];
            System.arraycopy(dp, 0, t, 0, n);
            for (int[] x : flights) {
                t[x[1]] = Math.min(t[x[1]], dp[x[0]] + x[2]);
            }
            dp = t;
        }
        return (dp[dst] == val) ? -1 : dp[dst];
    }
}
