package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0268_Missing_Number {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            n ^= i;
            n ^= nums[i];
        }
        return n;
    }

    public int missingNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n ^= i + 1;
            n ^= nums[i];
        }
        return n;
    }
}
