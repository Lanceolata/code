package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_1024_Video_Stitching {
    public int videoStitching(int[][] clips, int time) {
        int res = 0;
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        for (int i = 0, st = 0, end = 0; st < time; st = end, ++res) {
            System.out.println(i + "\t" + st + "\t" + end);
            for (; i < clips.length && clips[i][0] <= st; ++i) {
                end = Math.max(end, clips[i][1]);
            }
            if (st == end) {
                return -1;
            }
        }
        return res;
    }
}
