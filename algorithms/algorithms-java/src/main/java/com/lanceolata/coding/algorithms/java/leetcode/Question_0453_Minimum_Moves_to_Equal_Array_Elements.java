package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0453_Minimum_Moves_to_Equal_Array_Elements {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        long sum = 0, n = nums[0];
        for (long num : nums) {
            sum += num;
            n = Math.min(num, n);
        }
        return (int)(sum - n * nums.length);
    }
}
