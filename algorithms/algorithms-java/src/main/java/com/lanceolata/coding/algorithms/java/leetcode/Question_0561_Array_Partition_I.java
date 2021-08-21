package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0561_Array_Partition_I {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }
}
