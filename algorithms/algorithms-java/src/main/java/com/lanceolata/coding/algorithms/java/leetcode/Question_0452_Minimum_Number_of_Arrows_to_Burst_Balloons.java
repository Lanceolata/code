package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0452_Minimum_Number_of_Arrows_to_Burst_Balloons {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int res = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (end >= points[i][0]) {
                continue;
            }
            res++;
            end = points[i][1];
        }
        return res;
    }
}
