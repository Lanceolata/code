package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0622_Design_Circular_Queue {
    private int[] arr;
    private int head, tail;
    private boolean reset;
    public Question_0622_Design_Circular_Queue(int k) {
        this.arr = new int[k];
        this.head = 0;
        this.tail = 0;
        this.reset = true;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            reset = false;
        }
        arr[tail] = value;
        tail = (tail + 1) % arr.length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % arr.length;
        if (isFull()) {
            reset = true;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(tail + arr.length - 1) % arr.length];
    }

    public boolean isEmpty() {
        return head == tail && reset;
    }

    public boolean isFull() {
        return head == tail && !reset;
    }
}
