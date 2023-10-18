package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.PriorityQueue;

public class Question_1046_Last_Stone_Weight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int s : stones) {
            pq.offer(s);
        }
        while (pq.size() > 1) {
            pq.offer(pq.poll() - pq.poll());
        }
        return pq.poll();
    }
}
