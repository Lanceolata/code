package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0049_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String tmp = new String(array);
            if (map.containsKey(tmp)) {
                map.get(tmp).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(tmp, list);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
