package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0997_Find_the_Town_Judge {
    public int findJudge(int n, int[][] trust) {
        int[] v1 = new int[n], v2 = new int[n];
        for (int[] t : trust) {
            v1[t[0] - 1]++;
            v2[t[1] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (v1[i] == 0 && v2[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}
