package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0851_Loud_and_Rich {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> richer2 = new HashMap<>();
        int n = quiet.length;
        for (int i = 0; i < n; ++i) {
            richer2.put(i, new ArrayList<>());
        }
        for (int[] v : richer) {
            richer2.get(v[1]).add(v[0]);
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            dfs(i, quiet, richer2, res);
        }
        return res;
    }

    private int dfs(int i, int[] quiet, Map<Integer, List<Integer>> richer2, int[] res) {
        if (res[i] >= 0) {
            return res[i];
        }
        res[i] = i;
        for (int j : richer2.get(i)) {
            if (quiet[res[i]] > quiet[dfs(j, quiet, richer2, res)]) {
                res[i] = res[j];
            }
        }
        return res[i];
    }
}
