package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0767_Reorganize_String {
    public String reorganizeString(String s) {
        int[] cnts = new int[26];
        Arrays.fill(cnts, 0);
        int mostFreq = 0, i = 0;
        for (char c : s.toCharArray()) {
            if (++cnts[c - 'a'] > cnts[mostFreq]) {
                mostFreq = (c - 'a');
            }
        }
        if (2 * cnts[mostFreq] - 1 > s.length()) {
            return "";
        }
        char[] arr = s.toCharArray();
        while (cnts[mostFreq] > 0) {
            arr[i] = (char) ('a' + mostFreq);
            i += 2;
            cnts[mostFreq]--;
        }
        for (int j = 0; j < 26; j++) {
            while (cnts[j] > 0) {
                if (i >= arr.length) {
                    i = 1;
                }
                arr[i] = (char) ('a' + j);
                cnts[j]--;
                i += 2;
            }
        }
        return new String(arr);
    }
}
