package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0017_Letter_Combinations_of_a_Phone_Number {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] strs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        help(digits, 0, "", strs, res);
        return res;
    }

    private void help(String digits, int i, String s, String[] strs, List<String> res) {
        if (i >= digits.length()) {
            res.add(s);
            return;
        }
        String str = strs[digits.charAt(i) - '2'];
        for (int j = 0; j < str.length(); j++) {
            help(digits, i + 1, s + str.charAt(j), strs, res);
        }
    }
}
