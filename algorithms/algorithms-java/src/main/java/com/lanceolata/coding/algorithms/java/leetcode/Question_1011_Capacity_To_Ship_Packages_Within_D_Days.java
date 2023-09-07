package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1011_Capacity_To_Ship_Packages_Within_D_Days {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 25000000;
        for (int w : weights) {
            l = Math.max(l, w);
        }
        while (l < r) {
            int m = l + (r - l) / 2, need = 1, cur = 0;
            for (int i = 0; i < weights.length && need <= days; cur += weights[i++]) {
                if (cur + weights[i] > m) {
                    cur = 0;
                    need++;
                }
            }
            if (need > days) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
