package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Stack;

public class Question_0020_Valid_Parentheses {
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    // 注意判断是否为空
                    if (stack.empty() || stack.peek() != c) {
                        return false;
                    } else {
                        stack.pop();
                    }
            }
        }
        // 注意判断是否为空
        return stack.empty();
    }
}
