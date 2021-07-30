package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0506_Relative_Ranks {
    public String[] findRelativeRanks(int[] score) {
        if (score == null || score.length == 0) {
            return new String[0];
        }
        int n = score.length;
        int[] nums = Arrays.copyOf(score, score.length);
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], n - i - 1);
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int index = map.get(score[i]);
            if (index == 0) {
                list.add("Gold Medal");
            } else if (index == 1) {
                list.add("Silver Medal");
            } else if (index == 2) {
                list.add("Bronze Medal");
            } else {
                list.add(index + 1 + "");
            }
        }
        return list.toArray(new String[0]);
    }
}
