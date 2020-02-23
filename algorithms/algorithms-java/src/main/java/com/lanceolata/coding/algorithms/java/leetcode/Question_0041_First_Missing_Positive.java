package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0041_First_Missing_Positive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 注意 nums[i] - 1
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
