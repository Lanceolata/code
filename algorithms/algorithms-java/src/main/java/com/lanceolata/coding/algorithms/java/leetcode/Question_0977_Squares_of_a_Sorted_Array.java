package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0977_Squares_of_a_Sorted_Array {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0, r = nums.length - 1;
        for (int i = res.length - 1; i >= 0; i--) {
            if (Math.abs(nums[r]) >= Math.abs(nums[l])) {
                res[i] = nums[r] * nums[r];
                r--;
            } else {
                res[i] = nums[l] * nums[l];
                l++;
            }
        }
        return res;
    }
}
