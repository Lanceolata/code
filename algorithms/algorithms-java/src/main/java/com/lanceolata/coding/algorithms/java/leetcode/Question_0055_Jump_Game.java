package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0055_Jump_Game {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int cur = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            cur = Math.max(cur, i + nums[i]);
            if (cur < i + 1) {
                return false;
            }
            if (cur >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}
