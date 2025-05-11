package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.TreeMap;

public class Question_0729_My_Calendar_I {
    private TreeMap<Integer, Integer> calendar;

    public Question_0729_My_Calendar_I() {
        calendar = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        Integer prev = calendar.floorKey(startTime),
                next = calendar.ceilingKey(startTime);
        if ((prev == null || calendar.get(prev) <= startTime) &&
                (next == null || endTime <= next)) {
            calendar.put(startTime, endTime);
            return true;
        }
        return false;
    }
}
