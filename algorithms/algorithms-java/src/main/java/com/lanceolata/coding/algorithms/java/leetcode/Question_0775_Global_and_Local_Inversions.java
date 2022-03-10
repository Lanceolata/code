package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0775_Global_and_Local_Inversions {
    public boolean isIdealPermutation(int[] nums) {
        int cmax = 0, n = nums.length;
        for (int i = 0; i < n - 2; ++i) {
            cmax = Math.max(cmax, nums[i]);
            if (cmax > nums[i + 2]) {
                return false;
            }
        }
        return true;
    }
}
