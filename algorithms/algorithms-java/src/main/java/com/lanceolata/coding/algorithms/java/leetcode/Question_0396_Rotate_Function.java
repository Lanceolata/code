package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0396_Rotate_Function {
    public int maxRotateFunction(int[] nums) {
        long sum = 0, F = 0;
        for (int i = 0; i < nums.length; i++) {
            F += i * nums[i];
            sum += nums[i];
        }
        long res = F;
        for (int i = nums.length - 1; i >= 1; i--) {
            F = F + sum - nums.length * (long)nums[i];
            res = Math.max(res, F);
        }
        return (int)res;
    }
}
