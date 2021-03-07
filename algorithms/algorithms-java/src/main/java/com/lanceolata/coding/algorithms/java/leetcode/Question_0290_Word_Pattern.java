package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Map;
import java.util.HashMap;

public class Question_0290_Word_Pattern {
    public boolean wordPattern(String pattern, String s) {
        if (pattern == null || s == null) {
            return false;
        }
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(arr[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(arr[i])) {
                    return false;
                }
                map.put(c, arr[i]);
            }
        }
        return true;
    }
}
