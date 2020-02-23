package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.List;

public class Question_0120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return -1;
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> cur = triangle.get(i);
            List<Integer> sub = triangle.get(i + 1);
            for (int j = 0; j < cur.size(); j++) {
                cur.set(j, cur.get(j) + Math.min(sub.get(j), sub.get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
