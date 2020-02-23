package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question_0447_Number_of_Boomerangs {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int d = distance(points[i], points[j]);
                if (!map.containsKey(d)) {
                    map.put(d, 1);
                } else {
                    map.put(d, map.get(d) + 1);
                }
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                res += entry.getValue() * (entry.getValue() - 1);
            }
            map.clear();
        }
        return res;
    }

    private int distance(int[] v1, int[] v2) {
        int dx = v1[0] - v2[0];
        int dy = v1[1] - v2[1];
        return dx * dx + dy * dy;
    }
}
