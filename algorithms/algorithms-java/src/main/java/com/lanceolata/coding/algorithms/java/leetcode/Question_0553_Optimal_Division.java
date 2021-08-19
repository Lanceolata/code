package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0553_Optimal_Division {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return nums[0] + "";
        }
        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder res = new StringBuilder(nums[0] + "/(" + nums[1]);
        for (int i = 2; i < nums.length; i++) {
            res.append("/").append(nums[i]);
        }
        res.append(")");
        return res.toString();
    }
}
