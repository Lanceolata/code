package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Question_0128_Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int res = 0;
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int cnt = 0;
                while (set.contains(n)) {
                    cnt++;
                    n++;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
