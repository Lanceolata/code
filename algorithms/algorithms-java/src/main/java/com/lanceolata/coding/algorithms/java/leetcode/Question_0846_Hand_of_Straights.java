package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class Question_0846_Hand_of_Straights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> c = new TreeMap<>();
        for (int i : hand) {
            c.put(i, c.getOrDefault(i, 0) + 1);
        }
        for (int it : c.keySet()) {
            if (c.get(it) > 0) {
                for (int i = groupSize - 1; i >= 0; --i) {
                    if (c.getOrDefault(it + i, 0) < c.get(it)) {
                        return false;
                    }
                    c.put(it + i, c.get(it + i) - c.get(it));
                }
            }
        }
        return true;
    }
}
