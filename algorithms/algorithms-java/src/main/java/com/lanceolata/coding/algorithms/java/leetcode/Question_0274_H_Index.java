package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0274_H_Index {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations.length - 1 - i >= citations[i]) {
                return citations.length - 1 - i;
            }
        }
        return citations.length;
    }
}
