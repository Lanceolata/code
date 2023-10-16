package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question_1042_Flower_Planting_With_No_Adjacent {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, Set<Integer>> greed = new HashMap<>();
        for (int i = 0; i < n; i++) {
            greed.put(i, new HashSet<>());
        }
        for (int[] p : paths) {
            greed.get(p[0] - 1).add(p[1] - 1);
            greed.get(p[1] - 1).add(p[0] - 1);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int[] colors = new int[5];
            for (int j : greed.get(i)) {
                colors[res[j]] = 1;
            }
            for (int c = 4; c > 0; --c) {
                if (colors[c] == 0) {
                    res[i] = c;
                }
            }
        }
        return res;
    }
}
