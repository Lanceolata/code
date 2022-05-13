package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Stack;

public class Question_0962_Maximum_Width_Ramp {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int res = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (s.empty() || nums[s.peek()] > nums[i]) {
                s.add(i);
            }
        }
        for (int i = n - 1; i > res; --i) {
            while (!s.empty() && nums[s.peek()] <= nums[i]) {
                res = Math.max(res, i - s.pop());
            }
        }
        return res;
    }
}
