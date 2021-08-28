package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0581_Shortest_Unsorted_Continuous_Subarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int i = 0, j = nums.length - 1, n = nums.length;
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        while (i < n && nums[i] == copy[i]) {
            i++;
        }
        while (j > i && nums[j] == copy[j]) {
            j--;
        }
        return j - i + 1;
    }
}
