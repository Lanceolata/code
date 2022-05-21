package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0986_Interval_List_Intersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            if (firstList[i][1] < secondList[j][0]) {
                i++;
                continue;
            }
            if (firstList[i][0] > secondList[j][1]) {
                j++;
                continue;
            }
            res.add(new int[]{Math.max(firstList[i][0], secondList[j][0]), Math.min(firstList[i][1], secondList[j][1])});
            if (firstList[i][1] >= secondList[j][1]) {
                j++;
            } else {
                i++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
