package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0921_Minimum_Add_to_Make_Parentheses_Valid {
    public int minAddToMakeValid(String s) {
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                r++;
            } else if (r > 0) {
                r--;
            } else {
                l++;
            }
        }
        return l + r;
    }
}
