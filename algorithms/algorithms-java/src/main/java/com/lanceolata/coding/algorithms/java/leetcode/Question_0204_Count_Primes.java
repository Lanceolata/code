package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0204_Count_Primes {
    public int countPrimes(int n) {
        if (n <= 0) {
            return 0;
        }
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                res++;
                for (int j = 2; i * j < n; j++) {
                    prime[i * j] = false;
                }
            }
        }
        return res;
    }
}
