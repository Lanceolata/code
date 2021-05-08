package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0334_Increasing_Triplet_Subsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int small = Integer.MAX_VALUE, medium = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) {
                small = n;
            } else if (n <= medium) {
                medium = n;
            } else {
                return true;
            }
        }
        return false;
    }
}
