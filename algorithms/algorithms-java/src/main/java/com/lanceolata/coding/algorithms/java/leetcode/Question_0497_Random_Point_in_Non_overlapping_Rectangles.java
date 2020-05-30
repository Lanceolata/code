package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Random;
import java.util.TreeMap;

public class Question_0497_Random_Point_in_Non_overlapping_Rectangles {
    private int[][] rects;
    private int total;
    private TreeMap<Integer, Integer> map;
    private Random random;

    public Question_0497_Random_Point_in_Non_overlapping_Rectangles(int[][] rects) {
        this.rects = rects;
        this.total = 0;
        this.map = new TreeMap<>();
        this.random = new Random();
        for(int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            this.total += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            map.put(this.total, i);
        }
    }

    public int[] pick() {
        int val = random.nextInt(total) + 1;
        int idx = map.get(map.ceilingKey(val));
        int width = rects[idx][2] - rects[idx][0] + 1;
        int height = rects[idx][3] - rects[idx][1] + 1;
        return new int[] {random.nextInt(width) + rects[idx][0], random.nextInt(height) + rects[idx][1]};
    }
}
