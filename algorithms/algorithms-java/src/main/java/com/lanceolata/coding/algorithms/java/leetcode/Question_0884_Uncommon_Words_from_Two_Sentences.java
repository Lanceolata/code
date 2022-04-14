package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question_0884_Uncommon_Words_from_Two_Sentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> count = new HashMap<>();
        for (String w : (s1 + " " + s2).split(" ")) {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (String w : count.keySet()) {
            if (count.get(w) == 1) {
                res.add(w);
            }
        }
        return res.toArray(new String[0]);
    }
}
