package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.TreeMap;

public class Question_0732_My_Calendar_III {

    private TreeMap<Integer, Integer> timeline = new TreeMap<>();

    public Question_0732_My_Calendar_III() {

    }

    public int book(int startTime, int endTime) {
        timeline.put(startTime, timeline.getOrDefault(startTime, 0) + 1); // 1 new event will be starting at [s]
        timeline.put(endTime, timeline.getOrDefault(endTime, 0) - 1); // 1 new event will be ending at [e];
        int ongoing = 0, k = 0;
        for (int v : timeline.values()) {
            k = Math.max(k, ongoing += v);
        }
        return k;
    }
}
