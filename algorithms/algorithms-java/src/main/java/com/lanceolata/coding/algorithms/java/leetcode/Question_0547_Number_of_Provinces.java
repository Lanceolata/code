package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0547_Number_of_Provinces {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0
                || isConnected[0] == null || isConnected[0].length != isConnected.length) {
            return 0;
        }
        boolean[] visited = new boolean[isConnected.length];
        Arrays.fill(visited, false);
        int res = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(i, isConnected, visited);
            res++;
        }
        return res;
    }

    private void dfs(int i, int[][] isConnected, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (i == j || visited[j] || isConnected[i][j] == 0) {
                continue;
            }
            dfs(j, isConnected, visited);
        }
    }
}
