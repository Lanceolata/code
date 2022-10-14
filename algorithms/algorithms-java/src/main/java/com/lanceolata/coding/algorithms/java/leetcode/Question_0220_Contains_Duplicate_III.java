package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.TreeSet;

public class Question_0220_Contains_Duplicate_III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length <= 1 || indexDiff < 1 || valueDiff < 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > indexDiff) {
                set.remove((long) nums[i - indexDiff - 1]);
            }
            long n = nums[i];
            if ((set.floor(n) != null && n <= valueDiff + set.floor(n))
                    || (set.ceiling(n) != null && set.ceiling(n) <= valueDiff + n)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }
}
