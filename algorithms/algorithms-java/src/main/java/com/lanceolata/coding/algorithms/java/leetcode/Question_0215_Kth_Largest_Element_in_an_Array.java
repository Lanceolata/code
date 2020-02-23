package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0215_Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
