package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0791_Custom_Sort_String {
    public String customSortString(String order, String s) {
        int[] bucket = new int[26];
        for (char c : s.toCharArray()) {
            bucket[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            for (int i = 0; i < bucket[c - 'a']; i++) {
                sb.append(c);
            }
            bucket[c - 'a'] = 0;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}
