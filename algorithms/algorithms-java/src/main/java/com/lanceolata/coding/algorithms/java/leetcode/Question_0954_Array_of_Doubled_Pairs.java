package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class Question_0954_Array_of_Doubled_Pairs {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int i : arr) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        for (int x : count.keySet()) {
            if (count.get(x) == 0) {
                continue;
            }
            int want = x < 0 ? x / 2 : x * 2;
            if (x < 0 && x % 2 != 0 || count.get(x) > count.getOrDefault(want, 0)) {
                return false;
            }
            count.put(want, count.get(want) - count.get(x));
        }
        return true;
    }
}
