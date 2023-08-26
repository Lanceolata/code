package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question_1002_Find_Common_Characters {
    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : words[0].toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        for (int i = 1; i < words.length; i++) {
            Map<Character, Integer> nCounts = new HashMap<>();
            for (char c : words[i].toCharArray()) {
                if (counts.getOrDefault(c, 0) > 0) {
                    nCounts.put(c, nCounts.getOrDefault(c, 0) + 1);
                    counts.put(c, counts.get(c) - 1);
                }
            }
            counts = nCounts;
        }
        for (Map.Entry<Character, Integer> e : counts.entrySet()) {
            for (int i = 0; i < e.getValue(); i++) {
                res.add(String.valueOf(e.getKey()));
            }
        }
        return res;
    }
}
