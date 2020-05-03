package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0475_Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        int res = 0, n = heaters.length;
        Arrays.sort(heaters);
        for (int house : houses) {
            int l = 0, r = n, m;
            while (l < r) {
                m = l + (r - l) / 2;
                if (heaters[m] < house) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            int dist1 = (r == n) ? Integer.MAX_VALUE : heaters[r] - house;
            int dist2 = (r == 0) ? Integer.MAX_VALUE : house - heaters[r - 1];
            res = Math.max(res, Math.min(dist1, dist2));
        }
        return res;
    }
}
