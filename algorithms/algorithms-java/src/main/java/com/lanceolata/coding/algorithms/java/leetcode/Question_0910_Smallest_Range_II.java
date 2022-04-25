package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0910_Smallest_Range_II {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, mx = nums[n - 1], mn = nums[0], res = mx - mn;
        for (int i = 0; i < n - 1; ++i) {
            mx = Math.max(mx, nums[i] + 2 * k);
            mn = Math.min(nums[i + 1], nums[0] + 2 * k);
            res = Math.min(res, mx - mn);
        }
        return res;
    }
}
