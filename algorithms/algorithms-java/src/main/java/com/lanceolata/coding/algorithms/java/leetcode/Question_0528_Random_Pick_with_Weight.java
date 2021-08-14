package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Random;

public class Question_0528_Random_Pick_with_Weight {
    private Random random;
    private int[] sums;

    public Question_0528_Random_Pick_with_Weight(int[] w) {
        this.random = new Random();
        int[] arr = new int[w.length];
        arr[0] = w[0];
        for (int i = 1; i < w.length; ++i) {
            arr[i] = arr[i - 1] + w[i];
        }
        this.sums = arr;
    }

    public int pickIndex() {
        int idx = random.nextInt(sums[sums.length - 1]);
        int l = 0, r = sums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (sums[m] <= idx) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
}
