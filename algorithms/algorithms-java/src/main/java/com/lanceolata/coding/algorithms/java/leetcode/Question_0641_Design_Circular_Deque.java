package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0641_Design_Circular_Deque {
    private int[] buffer;
    private int cnt;
    private int k;
    private int front;
    private int rear;
    public Question_0641_Design_Circular_Deque(int k) {
        this.buffer = new int[k];
        this.cnt = 0;
        this.k = k;
        this.front = k - 1;
        this.rear = 0;
    }

    public boolean insertFront(int value) {
        if (cnt == k) {
            return false;
        }
        buffer[front] = value;
        front = (front - 1 + k) % k;
        cnt++;
        return true;
    }

    public boolean insertLast(int value) {
        if (cnt == k) {
            return false;
        }
        buffer[rear] = value;
        rear = (rear + 1) % k;
        ++cnt;
        return true;
    }

    public boolean deleteFront() {
        if (cnt == 0) {
            return false;
        }
        front = (front + 1) % k;
        --cnt;
        return true;
    }

    public boolean deleteLast() {
        if (cnt == 0) {
            return false;
        }
        rear = (rear - 1 + k) % k;
        --cnt;
        return true;
    }

    public int getFront() {
        if (cnt == 0) {
            return -1;
        }
        return buffer[(front + 1) % k];
    }

    public int getRear() {
        if (cnt == 0) {
            return -1;
        }
        return buffer[(rear - 1 + k) % k];
    }

    public boolean isEmpty() {
        return cnt == 0;
    }

    public boolean isFull() {
        return cnt == k;
    }
}
