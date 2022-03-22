package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0821_Shortest_Distance_to_a_Character {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] res = new int[n];
        Arrays.fill(res, n);
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            if (idx != -1) {
                res[i] = Math.min(res[i], i - idx);
            }
        }
        idx = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            if (idx != -1) {
                res[i] = Math.min(res[i], idx - i);
            }
        }
        return res;
    }
}
