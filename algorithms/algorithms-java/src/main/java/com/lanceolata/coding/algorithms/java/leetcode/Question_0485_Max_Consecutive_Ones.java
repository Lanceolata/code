package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0485_Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0, cnt = 0;
        for (int n : nums) {
            if (n == 1) {
                cnt++;
                res = Math.max(res, cnt);
            } else {
                cnt = 0;
            }
        }
        return res;
    }
}
