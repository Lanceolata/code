package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question_0890_Find_and_Replace_Pattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList();
        for (String word : words) {
            if (help(word, pattern)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean help(String word, String pattern) {
        Map<Character, Character> m = new HashMap();
        for (int i = 0; i < word.length(); ++i) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!m.containsKey(w)) {
                m.put(w, p);
            }
            if (m.get(w) != p) {
                return false;
            }
        }
        boolean[] visited = new boolean[26];
        for (char p : m.values()) {
            if (visited[p - 'a']) {
                return false;
            }
            visited[p - 'a'] = true;
        }
        return true;
    }
}
