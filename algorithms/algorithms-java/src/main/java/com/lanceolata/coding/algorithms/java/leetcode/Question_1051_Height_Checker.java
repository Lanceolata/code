package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_1051_Height_Checker {
    public int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (expected[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }
}
