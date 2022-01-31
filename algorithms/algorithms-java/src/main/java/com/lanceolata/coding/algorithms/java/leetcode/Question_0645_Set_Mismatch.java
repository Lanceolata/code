package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0645_Set_Mismatch {
    public int[] findErrorNums(int[] nums) {
        int dup = 0, miss = 0;
        for (int n : nums) {
            int index = Math.abs(n) - 1;
            if (nums[index] < 0) {
                dup = Math.abs(n);
            } else {
                nums[index] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                miss = i + 1;
            }
        }
        return new int[] {dup, miss};
    }
}
