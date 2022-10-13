package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0218_The_Skyline_Problem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (prev != cur) {
                List<Integer> list = new ArrayList<>();
                list.add(h[0]);
                list.add(cur);
                res.add(list);
                prev = cur;
            }
        }
        return res;
    }
}
