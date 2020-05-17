package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question_0491_Increasing_Subsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 2) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        help(nums, 0, list, res);
        return res;
    }

    private void help(int[] nums, int i, List<Integer> list, List<List<Integer>> res) {
        if (list.size() >= 2) {
            res.add(new ArrayList<>(list));
        }
        Set<Integer> set = new HashSet<>();
        for (int j = i; j < nums.length; j++) {
            if ((!list.isEmpty() && list.get(list.size() - 1) > nums[j]) || set.contains(nums[j])) {
                continue;
            }
            list.add(nums[j]);
            set.add(nums[j]);
            help(nums, j + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
