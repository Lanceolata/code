package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Question_0354_Russian_Doll_Envelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr1[1] - arr2[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
