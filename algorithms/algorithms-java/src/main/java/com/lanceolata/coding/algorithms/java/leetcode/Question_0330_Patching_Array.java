package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0330_Patching_Array {
    public int minPatches(int[] nums, int n) {
        if (nums == null || n <= 0) {
            return 0;
        }
        long miss = 1;
        int res = 0, i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                res++;
            }
        }
        return res;
    }
}
