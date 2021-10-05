package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Question_0435_Non_overlapping_Intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int res = 1, end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                res++;
                end = intervals[i][1];
            }
        }
        return intervals.length - res;
    }
}
