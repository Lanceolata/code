package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.List;

public class Question_0524_Longest_Word_in_Dictionary_through_Deleting {
    public String findLongestWord(String s, List<String> dictionary) {
        if (s == null || dictionary == null || dictionary.isEmpty()) {
            return null;
        }
        String res = "";
        for (String str : dictionary) {
            int i = 0;
            for (int j = 0; i < str.length() && j < s.length(); j++) {
                if (str.charAt(i) == s.charAt(j)) {
                    i++;
                }
            }
            if (i == str.length() && str.length() >= res.length()) {
                if (str.length() > res.length() || str.compareTo(res) < 0) {
                    res = str;
                }
            }
        }
        return res;
    }
}
