package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0332_Reconstruct_Itinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.isEmpty()) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> l : tickets) {
            if (!map.containsKey(l.get(0))) {
                map.put(l.get(0), new ArrayList<>());
            }
            map.get(l.get(0)).add(l.get(1));
        }
        for (String k : map.keySet()) {
            map.get(k).sort(null);
        }
        dfs(map, "JFK", res);
        Collections.reverse(res);
        return res;
    }

    private void dfs(Map<String, List<String>> map, String s, List<String> res) {
        while (map.containsKey(s) && !map.get(s).isEmpty()) {
            String t = map.get(s).get(0);
            map.get(s).remove(0);
            dfs(map, t, res);
        }
        res.add(s);
    }
}
