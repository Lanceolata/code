package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0152_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preMax = nums[0], preMin = nums[0], curMax = 0, curMin = 0, res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], Math.max(preMax * nums[i], preMin * nums[i]));
            curMin = Math.min(nums[i], Math.min(preMax * nums[i], preMin * nums[i]));
            res = Math.max(res, curMax);
            preMax = curMax;
            preMin = curMin;
        }
        return res;
    }
}
