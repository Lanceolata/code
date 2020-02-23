package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0076_Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return null;
        }
        int[] counts = new int[256];
        for (int i = 0; i < t.length(); i++) {
            counts[t.charAt(i)]++;
        }
        int start = -1, len = Integer.MAX_VALUE, cnt = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (counts[s.charAt(j)]-- > 0) {
                cnt++;
            }
            if (cnt == t.length()) {
                while (counts[s.charAt(i)]++ < 0) {
                    i++;
                }
                if (j - i + 1 < len) {
                    start = i;
                    len = j - i + 1;
                }
                i++; cnt--;
            }
        }
        return start >= 0 ? s.substring(start, start + len) : "";
    }
}
