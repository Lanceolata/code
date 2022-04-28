package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question_0914_X_of_a_Kind_in_a_Deck_of_Cards {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int i : deck) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        for (int i : count.values()) {
            res = gcd(i, res);
        }
        return res > 1;
    }

    public int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
