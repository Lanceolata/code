package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.TreeMap;

public class Question_0731_My_Calendar_II {
    private TreeMap<Integer, Integer> calendar;

    public Question_0731_My_Calendar_II() {
        calendar = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        calendar.put(startTime, calendar.getOrDefault(startTime, 0) + 1);
        calendar.put(endTime, calendar.getOrDefault(endTime, 0) - 1);
        int active = 0;
        for (int d : calendar.values()) {
            active += d;
            if (active >= 3) {
                calendar.put(startTime, calendar.get(startTime) - 1);
                calendar.put(endTime, calendar.get(endTime) + 1);
                return false;
            }
        }
        return true;
    }
}
