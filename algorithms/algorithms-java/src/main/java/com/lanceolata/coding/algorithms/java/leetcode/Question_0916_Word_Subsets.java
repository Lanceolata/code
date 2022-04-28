package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_0916_Word_Subsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] targets = new int[26];
        Arrays.fill(targets, 0);
        for (String w : words2) {
            int[] tmp = counts(w);
            for (int i = 0; i < 26; i++) {
                targets[i] = Math.max(targets[i], tmp[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for (String w : words1) {
            int[] tmp = counts(w);
            int i = 0;
            for (; i < 26; i++) {
                if (tmp[i] < targets[i]) {
                    break;
                }
            }
            if (i >= 26) {
                res.add(w);
            }
        }
        return res;
    }

    private int[] counts(String w) {
        int[] res = new int[26];
        Arrays.fill(res, 0);
        for (char c : w.toCharArray()) {
            res[c - 'a']++;
        }
        return res;
    }
}
