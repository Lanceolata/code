package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0413_Arithmetic_Slices {
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0, cur = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                cur += 1;
                res += cur;
            } else {
                cur = 0;
            }
        }
        return res;
    }
}
