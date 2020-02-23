package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Stack;

public class Question_0032_Longest_Valid_Parentheses {
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        int open = 0, close = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                res = Math.max(res, 2 * open);
            } else if (open < close) {
                open = close = 0;
            }
        }
        open = close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                res = Math.max(res, 2 * open);
            } else if (open > close) {
                open = close = 0;
            }
        }
        return res;
    }

    public int longestValidParentheses_stack(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
