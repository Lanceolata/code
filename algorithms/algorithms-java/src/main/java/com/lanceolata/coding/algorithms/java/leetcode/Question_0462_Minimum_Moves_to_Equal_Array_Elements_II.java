package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0462_Minimum_Moves_to_Equal_Array_Elements_II {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int res = 0, i = 0, j = nums.length - 1;
        Arrays.sort(nums);
        while (i < j) {
            res += nums[j--] - nums[i++];
        }
        return res;
    }
}
