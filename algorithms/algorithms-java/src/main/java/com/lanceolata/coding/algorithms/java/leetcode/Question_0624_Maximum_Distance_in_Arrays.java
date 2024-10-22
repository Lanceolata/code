package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.List;

public class Question_0624_Maximum_Distance_in_Arrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int gMax = arrays.get(0).get(arrays.get(0).size() - 1), gMin = arrays.get(0).get(0), res = 0;
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int lMax = array.get(array.size() - 1), lMin = array.get(0);
            res = Math.max(res, Math.max(gMax - lMin, lMax - gMin));
            gMax = Math.max(gMax, lMax);
            gMin = Math.min(gMin, lMin);
        }
        return res;
    }
}
