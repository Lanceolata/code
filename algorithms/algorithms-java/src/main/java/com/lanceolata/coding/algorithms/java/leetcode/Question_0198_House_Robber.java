package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0198_House_Robber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preRob = 0, preNotRob = 0;
        for (int n : nums) {
            int tmp = preRob;
            preRob = preNotRob + n;
            preNotRob = Math.max(preNotRob, tmp);
        }
        return Math.max(preRob, preNotRob);
    }
}
