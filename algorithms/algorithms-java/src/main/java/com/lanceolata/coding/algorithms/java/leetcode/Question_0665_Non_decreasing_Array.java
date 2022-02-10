package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0665_Non_decreasing_Array {
    public boolean checkPossibility(int[] nums) {
        for (int i = 1, err = 0; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                err++;
                if (err > 1 || (i > 1 && i < nums.length - 1 && nums[i - 2] > nums[i] && nums[i + 1] < nums[i - 1])) {
                    return false;
                }
            }
        }
        return true;
    }
}
