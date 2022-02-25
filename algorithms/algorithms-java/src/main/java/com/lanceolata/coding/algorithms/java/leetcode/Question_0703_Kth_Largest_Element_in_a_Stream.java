package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.PriorityQueue;

public class Question_0703_Kth_Largest_Element_in_a_Stream {
    private int k;
    private PriorityQueue<Integer> heap;

    public Question_0703_Kth_Largest_Element_in_a_Stream(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
        }
        while (heap.size() > k) {
            heap.poll();
        }
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}
