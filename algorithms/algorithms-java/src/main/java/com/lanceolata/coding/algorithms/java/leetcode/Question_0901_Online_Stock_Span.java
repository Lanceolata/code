package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Stack;

public class Question_0901_Online_Stock_Span {
    private Stack<int[]> stack;

    public Question_0901_Online_Stock_Span() {
        this.stack = new Stack<>();
    }

    public int next(int price) {
        int res = 1;
        while (!stack.empty() && stack.peek()[0] <= price) {
            res += stack.peek()[1];
            stack.pop();
        }
        stack.push(new int[]{price, res});
        return res;
    }
}
