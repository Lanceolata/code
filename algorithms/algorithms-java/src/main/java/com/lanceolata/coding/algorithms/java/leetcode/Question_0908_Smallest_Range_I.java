package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0908_Smallest_Range_I {
    public int smallestRangeI(int[] nums, int k) {
        int mx = nums[0], mn = nums[0];
        for (int a : nums) {
            mx = Math.max(mx, a);
            mn = Math.min(mn, a);
        }
        return Math.max(0, mx - mn - 2 * k);
    }
}
