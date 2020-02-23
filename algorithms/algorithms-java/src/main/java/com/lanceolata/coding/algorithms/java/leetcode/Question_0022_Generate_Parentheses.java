package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0022_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n < 0) {
            return res;
        }
        help(n, 0, 0, "", res);
        return res;
    }

    private void help(int n, int open, int close, String s, List<String> res) {
        // 判断结束长度为 2 * n
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        if (open < n) {
            help(n, open + 1, close, s + "(", res);
        }
        if (close < open) {
            help(n, open, close + 1, s + ")", res);
        }
    }
}
