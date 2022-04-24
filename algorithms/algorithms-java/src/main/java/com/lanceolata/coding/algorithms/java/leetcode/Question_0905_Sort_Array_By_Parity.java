package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0905_Sort_Array_By_Parity {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 0) {
                i++;
            }
            while (i < j && (nums[j] & 1) == 1) {
                j--;
            }
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        return nums;
    }
}
