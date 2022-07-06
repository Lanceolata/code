package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0313_Super_Ugly_Number {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;
        int[] indexes = new int[primes.length];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < primes.length; j++) {
                dp[i] = Math.min(dp[i], dp[indexes[j]] * primes[j]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (dp[i] == dp[indexes[j]] * primes[j]) {
                    indexes[j]++;
                }
            }
        }
        return (int)dp[n - 1];
    }
}
