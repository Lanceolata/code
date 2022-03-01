package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0724_Find_Pivot_Index {
    public int pivotIndex(int[] nums) {
        int sum = 0, l = 0;
        for (int n : nums) {
            sum += n;
        }
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (l == sum) {
                return i;
            }
            l += nums[i];
        }
        return -1;
    }
}
