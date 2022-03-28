package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Question_0841_Keys_and_Rooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Stack<Integer> keys = new Stack<>();
        for (int room : rooms.get(0)) {
            keys.push(room);
        }
        while (!keys.empty()) {
            int k = keys.pop();
            if (visited.contains(k)) {
                continue;
            }
            visited.add(k);
            for (int room : rooms.get(k)) {
                keys.push(room);
            }
        }
        return visited.size() == rooms.size();
    }
}
