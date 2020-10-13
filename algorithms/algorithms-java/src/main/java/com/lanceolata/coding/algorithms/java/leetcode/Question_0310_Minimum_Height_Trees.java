package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0310_Minimum_Height_Trees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        iList<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        List<Set<Integer>> nodes = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            nodes.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (nodes.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = nodes.get(i).iterator().next();
                nodes.get(j).remove(i);
                if (nodes.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
