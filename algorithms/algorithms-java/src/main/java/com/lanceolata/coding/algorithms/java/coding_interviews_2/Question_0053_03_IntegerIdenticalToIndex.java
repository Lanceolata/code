package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0053_03_IntegerIdenticalToIndex {
    public int GetNumberSameAsIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] == m) {
                return m;
            } else if (nums[m] > m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
