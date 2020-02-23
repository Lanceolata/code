package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0154_Find_Minimum_in_Rotated_Sorted_Array_II {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0, r = nums.length - 1, m;
        while (l < r) {
            m = l + (r - l) / 2;
            if (nums[m] < nums[r]) {
                r = m;
            } else if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r--;
            }
        }
        return nums[r];
    }
}
