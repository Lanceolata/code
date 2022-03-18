package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0802_Find_Eventual_Safe_States {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // 0 未遍历 1 正在遍历 2 已遍历结束
        int[] color = new int[n];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(i, color, graph)) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean dfs(int node, int[] color, int[][] graph) {
        if (color[node] > 0) {
            return color[node] == 2;
        }
        color[node] = 1;
        for (int nei : graph[node]) {
            if (color[nei] == 1 || !dfs(nei, color, graph)) {
                return false;
            }
        }
        color[node] = 2;
        return true;
    }
}
