package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question_0781_Rabbits_in_Forest {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : answers) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res += (entry.getValue() + entry.getKey()) / (entry.getKey() + 1) * (entry.getKey() + 1);
        }
        return res;
    }
}
