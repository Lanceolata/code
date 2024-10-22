package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0517_Super_Washing_Machines {
    public int findMinMoves(int[] machines) {
        int sum = 0, n = machines.length;
        for (int m : machines) {
            sum += m;
        }
        if (sum % n != 0) {
            return -1;
        }
        int part = sum / n, diff = 0, imbalance = 0, maxMoves = 0;
        for (int dresses : machines) {
            diff = dresses - part;
            imbalance += diff;
            maxMoves = Math.max(maxMoves, Math.max(Math.abs(imbalance), diff));
        }
        return maxMoves;
    }
}
