package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question_0963_Minimum_Area_Rectangle_II {
    public double minAreaFreeRect(int[][] points) {
        Map<String, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double x = (points[i][0] + points[j][0]) / 2.0;
                double y = (points[i][1] + points[j][1]) / 2.0;
                String key = x + "," + y + "," + getDist(points, i, j);
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(new int[]{i, j});
            }
        }
        double res = Double.MAX_VALUE;
        for (List<int[]> l : map.values()) {
            for (int i = 0; i < l.size(); i++) {
                for (int j = i + 1; j < l.size(); j++) {
                    res = Math.min(res, getArea(points, l.get(i), l.get(j)));
                }
            }
        }
        return res == Double.MAX_VALUE ? 0 : res;
    }

    private int getDist(int[][] p, int i, int j) {
        return (p[i][0] - p[j][0]) * (p[i][0] - p[j][0]) + (p[i][1] - p[j][1]) * (p[i][1] - p[j][1]);
    }

    private double getArea(int[][] p, int[] a, int[] b) {
        int dis1 = getDist(p, a[0], b[0]);
        int dis2 = getDist(p, a[0], b[1]);
        return Math.sqrt(dis1) * Math.sqrt(dis2);
    }
}
