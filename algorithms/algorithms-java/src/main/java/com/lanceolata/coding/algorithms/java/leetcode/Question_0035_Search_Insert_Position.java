package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0035_Search_Insert_Position {
	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
	}
}
