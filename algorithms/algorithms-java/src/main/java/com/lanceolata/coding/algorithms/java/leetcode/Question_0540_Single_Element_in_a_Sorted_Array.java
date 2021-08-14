package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0540_Single_Element_in_a_Sorted_Array {
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        if (nums == null) {
            return res;
        }
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }
}
