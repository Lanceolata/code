package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0748_Shortest_Completing_Word {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] cnts = new int[26];
        Arrays.fill(cnts, 0);
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                cnts[c - 'a']++;
            }
        }
        String res = null;
        for (String w : words) {
            if (help(w, cnts) && (res == null || w.length() < res.length())) {
                res = w;
            }
        }
        return res;
    }

    private boolean help(String w, int[] cnts) {
        int[] cnt = new int[26];
        Arrays.fill(cnt, 0);
        for (char c : w.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > cnts[i]) {
                return false;
            }
        }
        return true;
    }
}
