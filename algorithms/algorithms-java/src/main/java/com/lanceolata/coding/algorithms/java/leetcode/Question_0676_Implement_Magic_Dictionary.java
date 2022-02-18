package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question_0676_Implement_Magic_Dictionary {
    private Map<String, List<int[]>> map;

    public Question_0676_Implement_Magic_Dictionary() {
        this.map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            for (int i = 0; i < s.length(); i++) {
                String key = s.substring(0, i) + s.substring(i + 1);
                int[] pair = new int[]{i, s.charAt(i)};
                List<int[]> val = map.getOrDefault(key, new ArrayList<int[]>());
                val.add(pair);
                map.put(key, val);
            }
        }
    }

    public boolean search(String searchWord) {
        for (int i = 0; i < searchWord.length(); i++) {
            String key = searchWord.substring(0, i) + searchWord.substring(i + 1);
            if (map.containsKey(key)) {
                for (int[] pair : map.get(key)) {
                    if (pair[0] == i && pair[1] != searchWord.charAt(i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
