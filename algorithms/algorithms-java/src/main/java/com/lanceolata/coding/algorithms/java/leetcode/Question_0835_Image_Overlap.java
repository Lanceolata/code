package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question_0835_Image_Overlap {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n * n; ++i) {
            if (img1[i / n][i % n] == 1) {
                l1.add(i / n * 100 + i % n);
            }
        }
        for (int i = 0; i < n * n; ++i) {
            if (img2[i / n][i % n] == 1) {
                l2.add(i / n * 100 + i % n);
            }
        }
        for (int i : l1) {
            for (int j : l2) {
                count.put(i - j, count.getOrDefault(i - j, 0) + 1);
            }
        }
        int res = 0;
        for (int i : count.values()) {
            res = Math.max(res, i);
        }
        return res;
    }
}
