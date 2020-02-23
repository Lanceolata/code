package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0080_Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cnt = 1, i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[i]) {
                cnt++;
                if (cnt > 2) {
                    continue;
                }
            } else {
                cnt = 1;
            }
            nums[++i] = nums[j];
        }
        return i + 1;
    }
}
