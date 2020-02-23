package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0033_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int l = 0, r = nums.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] < nums[r]) {
                // 注意判断条件
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
