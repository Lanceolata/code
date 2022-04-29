package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0922_Sort_Array_By_Parity_II {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length, i = 0, j = nums.length - 1;
        while (i < n && j >= 0) {
            while (i < n && (nums[i] & 1) == 0) {
                i += 2;
            }
            while (j >= 0 && (nums[j] & 1) == 1) {
                j -= 2;
            }
            if (i < n && j >= 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i += 2;
                j -= 2;
            }
        }
        return nums;
    }
}
