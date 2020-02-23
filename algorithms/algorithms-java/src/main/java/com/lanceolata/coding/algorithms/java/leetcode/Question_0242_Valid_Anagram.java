package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0242_Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        Arrays.fill(table, 0);
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }
        for (int i : table) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
