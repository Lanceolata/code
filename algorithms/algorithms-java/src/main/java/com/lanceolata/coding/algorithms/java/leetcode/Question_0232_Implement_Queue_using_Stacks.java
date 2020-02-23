package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Stack;

public class Question_0232_Implement_Queue_using_Stacks {

    private Stack<Integer> stack;
    private Stack<Integer> help;

    /** Initialize your data structure here. */
    public Question_0232_Implement_Queue_using_Stacks() {
        stack = new Stack<>();
        help = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (help.empty()) {
            while (!stack.empty()) {
                help.push(stack.pop());
            }
        }
        return help.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (help.empty()) {
            while (!stack.empty()) {
                help.push(stack.pop());
            }
        }
        return help.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty() && help.empty();
    }
}
