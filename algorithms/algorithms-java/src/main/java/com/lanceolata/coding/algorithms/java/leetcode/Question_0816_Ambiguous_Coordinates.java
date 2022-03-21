package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0816_Ambiguous_Coordinates {
    public List<String> ambiguousCoordinates(String s) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n - 2; ++i) {
            List<String> left = help(s.substring(1, i + 1)), right = help(s.substring(i + 1, n - 1));
            for (String l : left) {
                for (String r : right) {
                    res.add("(" + l + ", " + r + ")");
                }
            }
        }
        return res;
    }

    public List<String> help(String s) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        if (n == 0 || (n > 1 && s.charAt(0) == '0' && s.charAt(n - 1) == '0')) {
            return res;
        }
        if (n > 1 && s.charAt(0) == '0') {
            res.add("0." + s.substring(1));
            return res;
        }
        res.add(s);
        if (n == 1 || s.charAt(n - 1) == '0') {
            return res;
        }
        for (int i = 1; i < n; ++i) {
            res.add(s.substring(0, i) + '.' + s.substring(i));
        }
        return res;
    }
}
