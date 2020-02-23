package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0003_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int[] index = new int[256];
        Arrays.fill(index, -1);
        int l = -1, res = 0;
        for (int i = 0; i < s.length(); i++) {
            l = Math.max(l, index[s.charAt(i)]);
            res = Math.max(res, i - l);
            index[s.charAt(i)] = i;
        }
        return res;
    }
}
