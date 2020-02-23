package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0228_Summary_Ranges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (j < nums.length - 1 && nums[j] + 1 == nums[j + 1]) {
                continue;
            }
            if (i == j) {
                res.add(nums[i] + "");
            } else {
                res.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return res;
    }
}
