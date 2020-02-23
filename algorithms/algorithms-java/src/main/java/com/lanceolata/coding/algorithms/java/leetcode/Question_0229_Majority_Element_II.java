package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0229_Majority_Element_II {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int m = 0, n = 0, cm = 0, cn = 0;
        for (int i : nums) {
            if (i == m) {
                cm++;
            } else if (i == n) {
                cn++;
            } else if (cm == 0) {
                m = i;
                cm = 1;
            } else if (cn == 0) {
                n = i;
                cn = 1;
            } else {
                cm--;
                cn--;
            }
        }
        cm = cn = 0;
        for (int i : nums) {
            if (i == m) {
                cm++;
            } else if (i == n) {
                cn++;
            }
        }
        if (cm > nums.length / 3) {
            res.add(m);
        }
        if (cn > nums.length / 3) {
            res.add(n);
        }
        return res;
    }
}
