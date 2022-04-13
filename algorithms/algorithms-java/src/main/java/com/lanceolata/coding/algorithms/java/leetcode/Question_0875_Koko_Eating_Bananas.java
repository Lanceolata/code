package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0875_Koko_Eating_Bananas {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0, m;
        for (int p : piles) {
            r = Math.max(r, p);
        }
        while (l < r) {
            m = l + (r - l) / 2;
            int spent = 0;
            for (int p : piles) {
                spent += p / m + ((p % m != 0) ? 1 : 0);
            }
            if (spent <= h) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}
