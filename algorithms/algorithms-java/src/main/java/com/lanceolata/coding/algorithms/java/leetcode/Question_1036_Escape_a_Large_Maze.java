package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question_1036_Escape_a_Large_Maze {
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Long> visS = new HashSet<>(), visT = new HashSet<>();
        for (int[] b : blocked) {
            if (Math.abs(b[0] - source[0]) + Math.abs(b[1] - source[1]) < 400) {
                visS.add(((long) b[0] << 32) + b[1]);
            }
            if (Math.abs(b[0] - target[0]) + Math.abs(b[1] - target[1]) < 400) {
                visT.add(((long) b[0] << 32) + b[1]);
            }
        }
        return bfs(visS, source, target, visS.size()) && bfs(visT, target, source, visT.size());
    }

    private boolean bfs(Set<Long> visited, int[] s, int[] t, int blocks) {
        List<int[]> q = new ArrayList<>();
        q.add(new int[]{s[0], s[1]});
        while (!q.isEmpty() && q.size() <= blocks) {
            List<int[]> q1 = new ArrayList<>();
            for (int[] p : q) {
                for (int[] d : dirs) {
                    int x = p[0] + d[0], y = p[1] + d[1];
                    if (x < 0 || x > 999999 || y < 0 || y > 999999) {
                        continue;
                    }
                    if (x == t[0] && y == t[1]) {
                        return true;
                    }
                    if (!visited.contains(((long) x << 32) + y)) {
                        visited.add(((long) x << 32) + y);
                        q1.add(new int[]{x, y});
                    }
                }
            }
            q = q1;
        }
        return !q.isEmpty();
    }
}
