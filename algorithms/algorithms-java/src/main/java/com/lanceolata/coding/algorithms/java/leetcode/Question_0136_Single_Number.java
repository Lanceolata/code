package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0136_Single_Number {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
