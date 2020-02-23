package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0057_Insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || newInterval == null) {
            return new int[0][0];
        }
        List<int[]> list = new ArrayList<>();
        int newStart = newInterval[0], newEnd = newInterval[1];
        boolean inserted = false;
        for (int i = 0; i < intervals.length; i++) {
            if (inserted || intervals[i][1] < newStart) {
                list.add(intervals[i]);
            } else if (intervals[i][0] > newEnd) {
                inserted = true;
                list.add(new int[] {newStart, newEnd});
                list.add(intervals[i]);
            } else {
                newStart = Math.min(newStart, intervals[i][0]);
                newEnd = Math.max(newEnd, intervals[i][1]);
            }
        }
        if (!inserted) {
            list.add(new int[] {newStart, newEnd});
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] item = list.get(i);
            res[i][0] = item[0];
            res[i][1] = item[1];
        }
        return res;
    }
}
