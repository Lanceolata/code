package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0789_Escape_The_Ghosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dist = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int t = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
            if (t <= dist) {
                return false;
            }
        }
        return true;
    }
}
