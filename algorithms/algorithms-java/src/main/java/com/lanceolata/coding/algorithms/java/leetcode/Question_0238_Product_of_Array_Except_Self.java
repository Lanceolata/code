package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0238_Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return null;
        }
        int[] res = new int[nums.length];
        int n = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = n;
            n *= nums[i];
        }
        n = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= n;
            n *= nums[i];
        }
        return res;
    }
}
