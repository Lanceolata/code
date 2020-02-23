package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0056_Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 0) {
            return new int[0][0];
        }
        int n = intervals.length;
        int[] starts = new int[n], ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<int[]> list = new ArrayList<>();
        for (int i = 0, j = 0; i < n; i++) {
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                list.add(new int[]{starts[j], ends[i]});
                j = i + 1;
            }
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
