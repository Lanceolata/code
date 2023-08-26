package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Stack;

public class Question_1003_Check_If_Word_Is_Valid_After_Substitutions {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) != 'a') {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                stack.push(c);
            } else if (c == 'b') {
                if (!stack.empty() && stack.peek() == 'a') {
                    stack.push(c);
                } else {
                    return false;
                }
            } else {
                if (!stack.empty() && stack.peek() == 'b') {
                    stack.pop();
                    if (!stack.empty() && stack.peek() == 'a') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
