package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0209_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE, sum = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                res = Math.min(res, j - i + 1);
                sum -= nums[i++];
            }
        }
        return (res == Integer.MAX_VALUE) ? 0 : res;
    }
}
