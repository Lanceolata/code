package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Question_0764_Largest_Plus_Sign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        Set<Integer> banned = new HashSet<>();
        int[][] dp = new int[n][n];
        for (int[] mine : mines) {
            banned.add(mine[0] * n + mine[1]);
        }
        int res = 0, count;
        for (int r = 0; r < n; r++) {
            // left
            count = 0;
            for (int c = 0; c < n; c++) {
                count = banned.contains(r * n + c) ? 0 : count + 1;
                dp[r][c] = count;
            }
            // right
            count = 0;
            for (int c = n - 1; c >= 0; c--) {
                count = banned.contains(r * n + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }
        for (int c = 0; c < n; c++) {
            // up
            count = 0;
            for (int r = 0; r < n; r++) {
                count = banned.contains(r * n + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
            // down
            count = 0;
            for (int r = n - 1; r >= 0; --r) {
                count = banned.contains(r * n + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                res = Math.max(res, dp[r][c]);
            }
        }
        return res;
    }
}
