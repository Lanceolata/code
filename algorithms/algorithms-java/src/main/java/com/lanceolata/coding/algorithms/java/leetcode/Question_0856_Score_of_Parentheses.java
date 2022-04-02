package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0856_Score_of_Parentheses {
    public int scoreOfParentheses(String s) {
        int res = 0, bal = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (s.charAt(i - 1) == '(') {
                    res += 1 << bal;
                }
            }
        }
        return res;
    }
}
