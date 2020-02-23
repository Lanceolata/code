package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0283_Move_Zeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                continue;
            }
            nums[i++] = nums[j];
        }
        for (; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
