package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.TreeMap;

public class Question_0731_My_Calendar_II {
    private TreeMap<Integer, Integer> calendar;

    public Question_0731_My_Calendar_II() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);
        int active = 0;
        for (int d : calendar.values()) {
            active += d;
            if (active >= 3) {
                calendar.put(start, calendar.get(start) - 1);
                calendar.put(end, calendar.get(end) + 1);
                return false;
            }
        }
        return true;
    }
}
