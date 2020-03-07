package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0451_Sort_Characters_By_Frequency {
    public String frequencySort(String s) {
        String[] arr = new String[s.length() + 1];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
            if (arr[entry.getValue()] == null) {
                arr[entry.getValue()] = sb.toString();
            } else {
                arr[entry.getValue()] += sb.toString();
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != null) {
                res.append(arr[i]);
            }
        }
        return res.toString();
    }
}
