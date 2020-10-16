package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0324_Wiggle_Sort_II {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        int k = (tmp.length + 1) / 2, j = nums.length;
        for (int i = 0; i < tmp.length; i++) {
            nums[i] = (i & 1) == 0 ? tmp[--k] : tmp[--j];
        }
    }
}
