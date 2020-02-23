package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0213_House_Robber_II {
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int start, int end) {
        int prerob = 0, prenotrob = 0;
        for (int i = start; i <= end; i++) {
            int temp = prerob;
            prerob = prenotrob + nums[i];
            prenotrob = Math.max(temp, prenotrob);
        }
        return Math.max(prerob, prenotrob);
    }
}
