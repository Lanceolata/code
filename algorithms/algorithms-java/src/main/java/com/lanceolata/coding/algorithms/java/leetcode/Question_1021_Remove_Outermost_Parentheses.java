package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1021_Remove_Outermost_Parentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int opened = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' && opened++ > 0) {
                res.append(c);
            }
            if (c == ')' && opened-- > 1) {
                res.append(c);
            }
        }
        return res.toString();
    }
}
