package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Stack;

public class Question_0150_Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if (isOperator(t)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(calc(a, b, t));
            } else {
                stack.push(Integer.valueOf(t));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String str) {
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))
            return true;
        return false;
    }

    private int calc(int a, int b, String operator) {
        char op = operator.charAt(0);
        switch (op) {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0) {
                return 0;
            } else {
                return a / b;
            }
        }
        return 0;
    }
}
