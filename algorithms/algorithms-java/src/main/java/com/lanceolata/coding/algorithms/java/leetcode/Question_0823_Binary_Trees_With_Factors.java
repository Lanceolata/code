package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question_0823_Binary_Trees_With_Factors {
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;
        Arrays.sort(arr);
        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            index.put(arr[i], i);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                    }
                }
            }
        }
        long res = 0;
        for (long v : dp) {
            res += v;
        }
        return (int) (res % MOD);
    }
}
