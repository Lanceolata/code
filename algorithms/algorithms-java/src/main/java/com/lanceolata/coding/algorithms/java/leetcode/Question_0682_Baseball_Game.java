package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Stack;

public class Question_0682_Baseball_Game {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();
        for(String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        int res = 0;
        for(int score : stack) {
            res += score;
        }
        return res;
    }
}
