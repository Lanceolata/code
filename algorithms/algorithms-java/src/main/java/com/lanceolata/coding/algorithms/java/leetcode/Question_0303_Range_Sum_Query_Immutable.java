package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0303_Range_Sum_Query_Immutable {
    private int[] sums;

    public Question_0303_Range_Sum_Query_Immutable(int[] nums) {
        sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
