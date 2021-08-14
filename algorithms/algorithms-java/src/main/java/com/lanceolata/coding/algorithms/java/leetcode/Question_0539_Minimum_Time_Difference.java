package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.List;

public class Question_0539_Minimum_Time_Difference {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.size() < 2) {
            return -1;
        }
        int n = timePoints.size();
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(timePoints.get(i).substring(0, 2));
            times[i] = 60 * h + Integer.parseInt(timePoints.get(i).substring(3, 5));
        }
        int res = Integer.MAX_VALUE;
        Arrays.sort(times);
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(times[i] - times[(i - 1 + n) % n]);
            diff = Math.min(diff, 1440 - diff);
            res = Math.min(res, diff);
        }
        return res;
    }
}
