package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0621_Task_Scheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[256];
        int count = 0;
        for (char c : tasks) {
            counts[c]++;
            count = Math.max(count, counts[c]);
        }
        int res = (count - 1) * (n + 1);
        for (int i : counts) {
            if (i == count) {
                res++;
            }
        }
        return Math.max(tasks.length, res);
    }
}
