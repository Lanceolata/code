package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0399_Evaluate_Division {

    private Map<String, Map<String, Double>> m;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        m = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> e = equations.get(i);
            if (!m.containsKey(e.get(0))) {
                m.put(e.get(0), new HashMap<>());
            }
            m.get(e.get(0)).put(e.get(1), values[i]);
            if (!m.containsKey(e.get(1))) {
                m.put(e.get(1), new HashMap<>());
            }
            m.get(e.get(1)).put(e.get(0), 1.0 / values[i]);
        }

        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            Set<String> visited = new HashSet<>();
            double t = help(q.get(0), q.get(1), visited);
            res[i] = t;
        }
        return res;
    }

    private double help(String up, String down, Set<String> visited) {
        if (m.containsKey(up) && m.get(up).containsKey(down)) {
            return m.get(up).get(down);
        }
        if (!m.containsKey(up)) {
            return -1.0;
        }
        for (Map.Entry<String, Double> entry : m.get(up).entrySet()) {
            if (visited.contains(entry.getKey())) {
                continue;
            }
            visited.add(entry.getKey());
            double t = help(entry.getKey(), down, visited);
            if (t > 0.0) {
                return t * entry.getValue();
            }
        }
        return -1.0;
    }
}
