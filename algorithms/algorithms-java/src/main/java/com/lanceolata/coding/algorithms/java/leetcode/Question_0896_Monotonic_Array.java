package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0896_Monotonic_Array {
    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int flag = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            int t = nums[i] > nums[i - 1] ? 1 : -1;
            if (flag != 0 && flag != t) {
                return false;
            }
            flag = t;
        }
        return true;
    }
}
