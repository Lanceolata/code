package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Question_0225_Implement_Stack_using_Queues {
    private Queue<Integer> q;
    private Queue<Integer> help;
    private int t;

    /** Initialize your data structure here. */
    public Question_0225_Implement_Stack_using_Queues() {
        q = new LinkedList<>();
        help = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);
        t = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (q.size() > 1) {
            t = q.poll();
            help.offer(t);
        }
        int res = q.poll();
        Queue<Integer> tmp = q;
        q = help;
        help = tmp;
        return res;
    }

    /** Get the top element. */
    public int top() {
        return t;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}
