package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_1018_Binary_Prefix_Divisible_By_5 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int cur = 0;
        for (int n : nums) {
            cur = cur * 2 % 5 + n;
            res.add(cur % 5 == 0);
        }
        return res;
    }
}
