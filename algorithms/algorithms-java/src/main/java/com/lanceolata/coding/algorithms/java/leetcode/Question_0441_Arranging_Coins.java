package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0441_Arranging_Coins {
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(2.0 * n + 0.25) - 0.5);
    }

    public int arrangeCoins2(int n) {
        long l = 0, r = n, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (m * (m + 1) / 2 <= n) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return (int)r;
    }
}
