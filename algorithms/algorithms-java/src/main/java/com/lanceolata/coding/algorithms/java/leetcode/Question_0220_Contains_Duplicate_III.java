package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.TreeSet;

public class Question_0220_Contains_Duplicate_III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k < 1 || t < 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove((long)nums[i - k - 1]);
            }
            long n = nums[i];
            if ((set.floor(n) != null && n <= t + set.floor(n))
                    || (set.ceiling(n) != null && set.ceiling(n) <= t + n)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }
}
