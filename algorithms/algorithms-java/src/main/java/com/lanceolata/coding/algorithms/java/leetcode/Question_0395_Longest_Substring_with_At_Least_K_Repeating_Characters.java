package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0395_Longest_Substring_with_At_Least_K_Repeating_Characters {
    public int longestSubstring(String s, int k) {
        int n = s.length(), max_idx = 0, res = 0;
        int[] index = new int[128];
        Arrays.fill(index, 0);
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            ++index[s.charAt(i)];
        }
        for (int i = 0; i < n; ++i) {
            if (index[s.charAt(i)] < k) {
                res = Math.max(res, longestSubstring(s.substring(max_idx, i), k));
                flag = false;
                max_idx = i + 1;
            }
        }
        return flag ? n : Math.max(res, longestSubstring(s.substring(max_idx, n), k));
    }
}
