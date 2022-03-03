package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.TreeMap;

public class Question_0729_My_Calendar_I {
    private TreeMap<Integer, Integer> calendar;

    public Question_0729_My_Calendar_I() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
