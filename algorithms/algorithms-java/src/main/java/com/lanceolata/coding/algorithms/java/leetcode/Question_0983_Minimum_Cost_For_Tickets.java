package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Question_0983_Minimum_Cost_For_Tickets {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> travel = Arrays.stream(days).boxed().collect(Collectors.toSet());
        int[] dp = new int[30];
        Arrays.fill(dp, 0);
        for (int d = days[0]; d <= days[days.length - 1]; d++) {
            if (!travel.contains(d)) {
                dp[d % 30] = dp[(d - 1) % 30];
            } else {
                dp[d % 30] = Math.min(dp[(d - 1) % 30] + costs[0], Math.min(dp[Math.max(0, d - 7) % 30] + costs[1], dp[Math.max(0, d - 30) % 30] + costs[2]));
            }
        }
        return dp[days[days.length - 1] % 30];
    }
}
