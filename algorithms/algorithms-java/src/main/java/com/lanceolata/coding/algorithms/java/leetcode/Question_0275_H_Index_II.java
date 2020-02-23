package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0275_H_Index_II {
    public int hIndex(int[] citations) {
        if (citations == null) {
            return 0;
        }
        int n = citations.length, l = 0, r = citations.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (citations[m] == n - m) {
                return n - m;
            } else if (citations[m] > n - m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return n - l;
    }
}
