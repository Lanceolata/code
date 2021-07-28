package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Question_0503_Next_Greater_Element_II {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                res[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return res;
    }
}
