package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0598_Range_Addition_II {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0) {
            return m * n;
        }
        int r = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
        for (int[] op : ops) {
            r = Math.min(r, op[0]);
            c = Math.min(c, op[1]);
        }
        return r * c;
    }
}
