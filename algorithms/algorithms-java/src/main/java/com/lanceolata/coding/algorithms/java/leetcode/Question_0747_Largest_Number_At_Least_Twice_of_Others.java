package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0747_Largest_Number_At_Least_Twice_of_Others {
    public int dominantIndex(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == idx) {
                continue;
            }
            if ((double) nums[idx] / nums[i] < 2.0) {
                return -1;
            }
        }
        return idx;
    }
}
