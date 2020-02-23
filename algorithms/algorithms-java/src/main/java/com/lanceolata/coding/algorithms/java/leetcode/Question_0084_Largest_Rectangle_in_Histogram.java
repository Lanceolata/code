package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Stack;

public class Question_0084_Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i <= heights.length; i++) {
            int cur = (i == heights.length) ? -1 : heights[i];
            while (!stack.empty() && heights[stack.peek()] >= cur) {
                int h = heights[stack.pop()];
                int w = stack.empty() ? i : i - stack.peek() - 1;
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }
        return res;
    }
}
