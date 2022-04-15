package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0886_Possible_Bipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[][] g = new int[n + 1][n + 1];
        for (int[] d : dislikes) {
            g[d[0]][d[1]] = 1;
            g[d[1]][d[0]] = 1;
        }
        int[] colors = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            if (colors[i] == 0 && !help(g, i, 1, colors)) {
                return false;
            }
        }
        return true;
    }

    private boolean help(int[][] g, int cur, int color, int[] colors) {
        colors[cur] = color;
        for (int i = 0; i < g.length; ++i) {
            if (g[cur][i] == 1) {
                if (colors[i] == color) {
                    return false;
                }
                if (colors[i] == 0 && !help(g, i, -color, colors)) {
                    return false;
                }
            }
        }
        return true;
    }
}
