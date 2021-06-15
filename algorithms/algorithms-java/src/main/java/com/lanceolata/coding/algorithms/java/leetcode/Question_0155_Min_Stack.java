package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Stack;

public class Question_0155_Min_Stack {
    private Stack<Long> stack;
    private long min;

    /** initialize your data structure here. */
    public Question_0155_Min_Stack() {
        this.stack = new Stack<>();
        this.min = 0L;
    }

    public void push(int val) {
        if (stack.empty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push(val - min);
            if (val < min) {
                min = val;
            }
        }
    }

    public void pop() {
        if (stack.empty()) {
            return;
        }
        long num = stack.pop();
        if (num < 0) {
            min -= num;
        }
    }

    public int top() {
        long num = stack.peek();
        if (num > 0) {
            return (int) (num + min);
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        return (int) min;
    }
}
