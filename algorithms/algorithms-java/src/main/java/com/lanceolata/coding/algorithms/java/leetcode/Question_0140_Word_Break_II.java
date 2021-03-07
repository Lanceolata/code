package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question_0140_Word_Break_II {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return help(s, wordDict, new HashMap<String, List<String>>());
    }

    private List<String> help(String s, List<String> wordDict, HashMap<String, List<String>> map) {
        if (map.containsKey(s)) {
          return map.get(s);
        }
        List<String> res = new ArrayList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = help(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) {
                    if (sub.isEmpty()) {
                        res.add(word);
                    } else {
                        res.add(word + " " + sub);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
