package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0785_Is_Graph_Bipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }
        colors[node] = color;
        for (int next : graph[node]) {
            if (!dfs(graph, colors, -color, next)) {
                return false;
            }
        }
        return true;
    }
}
