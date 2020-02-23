package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question_0436_Find_Right_Interval {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0];
        }
        int[] res = new int[intervals.length], starts = new int[intervals.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            map.put(intervals[i][0], i);
        }
        Arrays.sort(starts);
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            int start = binarySearch(starts, end);
            if (start < 0 || start >= starts.length) {
                res[i] = -1;
            } else {
                res[i] = map.get(starts[start]);
            }
        }
        return res;
    }

    public int binarySearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
