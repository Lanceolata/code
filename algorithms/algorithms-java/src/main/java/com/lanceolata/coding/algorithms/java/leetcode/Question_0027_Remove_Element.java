package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0027_Remove_Element {
    public int removeElement(int[] nums, int val) {
        if (nums == null | nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
