package com.lanceolata.coding.algorithms.java.coding_interviews_2;

import java.util.Deque;
import java.util.LinkedList;

public class Question_0059_02_QueueWithMax {
    private Deque<InternalData> data;
    private Deque<InternalData> maximums;
    private int currentIndex;

    public static class InternalData {
        private int index;
        private int number;
        public InternalData(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }

    public Question_0059_02_QueueWithMax() {
        this.data = new LinkedList<>();
        this.maximums = new LinkedList<>();
    }

    void push_back(int number) {
        while(!maximums.isEmpty() && number >= maximums.peekLast().number) {
            maximums.pollLast();
        }

        InternalData internalData = new InternalData(currentIndex, number);
        data.addLast(internalData);
        maximums.addLast(internalData);

        ++currentIndex;
    }

    void pop_front() {
        if(maximums.peekFirst().index == data.peekFirst().index) {
            maximums.pollFirst();
        }
        data.pollFirst();
    }

    int max() {
        return maximums.peekFirst().number;
    }
}
