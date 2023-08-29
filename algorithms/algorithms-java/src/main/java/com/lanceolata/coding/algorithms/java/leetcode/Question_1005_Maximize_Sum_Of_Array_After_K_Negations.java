package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_1005_Maximize_Sum_Of_Array_After_K_Negations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int j = 0, sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            if (nums[j] < 0) {
                nums[j] *= -1;
                if (j < nums.length - 1 && nums[j + 1] < Math.abs(nums[j])) {
                    j++;
                }
            } else if (nums[j] >= 0) {
                nums[j] *= -1;
            }
        }
        for (int n : nums) {
            sum += n;
        }
        return sum;
    }
}
