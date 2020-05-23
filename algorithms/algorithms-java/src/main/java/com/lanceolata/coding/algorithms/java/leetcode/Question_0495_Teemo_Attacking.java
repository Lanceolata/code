package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0495_Teemo_Attacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            int diff = timeSeries[i] - timeSeries[i - 1];
            res += Math.min(diff, duration);
        }
        return res + duration;
    }
}
