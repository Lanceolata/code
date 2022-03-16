package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0797_All_Paths_From_Source_to_Target {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(graph, 0, path, paths);
        return paths;
    }

    private void dfs(int[][] graph, int i, List<Integer> path, List<List<Integer>> paths) {
        path.add(i);
        if (i == graph.length - 1) {
            paths.add(new ArrayList<>(path));
        } else {
            for (int j : graph[i]) {
                dfs(graph, j, path, paths);
            }
        }
        path.remove(path.size() - 1);
    }
}
