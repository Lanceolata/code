package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Question_0295_Find_Median_from_Data_Stream {
    private Queue<Integer> small;
    private Queue<Integer> large;
    private boolean even;

    public Question_0295_Find_Median_from_Data_Stream() {
        this.small = new PriorityQueue<>(Collections.reverseOrder());
        this.large = new PriorityQueue<>();
        this.even = true;
    }

    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.peek();
        }
    }
}
