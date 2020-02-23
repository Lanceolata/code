package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0414_Third_Maximum_Number {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        long num1 = Long.MIN_VALUE, num2 = Long.MIN_VALUE, num3 = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1 || nums[i] == num3 || nums[i] == num2) {
                continue;
            }
            if (nums[i] > num1) {
                num3 = num2;
                num2 = num1;
                num1 = nums[i];
            } else if (nums[i] > num2) {
                num3 = num2;
                num2 = nums[i];
            } else if (nums[i] > num3) {
                num3 = nums[i];
            }
        }
        return num3 == Long.MIN_VALUE ? (int)num1 : (int)num3;
    }
}
