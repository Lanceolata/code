package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question_0808_Soup_Servings {
    private Map<Integer, Map<Integer, Double>> store = new HashMap<>();

    public double soupServings(int n) {
        if (n >= 4800) {
            return 1.0;
        } else {
            return help(n, n);
        }
    }

    private double help(int A, int B) {
        if (A == 0 && B != 0) {
            return 1;
        } else if (A == 0 && B == 0) {
            return 0.5;
        } else if (A != 0 && B == 0) {
            return 0;
        }
        if (store.containsKey(A) && store.get(A).containsKey(B)) {
            return store.get(A).get(B);
        }
        double prob = 0;
        prob += 0.25 * help(A - Math.min(A, 100), B);
        prob += 0.25 * help(A - Math.min(A, 75), B - Math.min(B, 25));
        prob += 0.25 * help(A - Math.min(A, 50), B - Math.min(B, 50));
        prob += 0.25 * help(A - Math.min(A, 25), B - Math.min(B, 75));
        if (!store.containsKey(A)) {
            store.put(A, new HashMap<>());
        }
        store.get(A).put(B, prob);
        return prob;
    }
}
