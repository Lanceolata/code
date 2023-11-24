package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1081_Smallest_Subsequence_of_Distinct_Characters {
    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        int[] m = new int[256], visited = new int[256];
        for(int i = 0; i < s.length(); i++) {
            m[s.charAt(i)]++;
        }
        StringBuilder res = new StringBuilder();
        res.append("0");
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            m[c]--;
            if (visited[c] == 1) {
                continue;
            }
            char last = res.charAt(res.length() - 1);
            while (c < last && m[last] > 0) {
                visited[last] = 0;
                res.deleteCharAt(res.length() - 1);
                last = res.charAt(res.length() - 1);
            }
            res.append(c);
            visited[c] = 1;
        }
        return res.substring(1);
    }
}
