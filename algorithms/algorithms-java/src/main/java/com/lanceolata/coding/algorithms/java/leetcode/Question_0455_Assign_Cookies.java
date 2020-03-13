package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0455_Assign_Cookies {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = 0; j < s.length; j++) {
            if (s[j] >= g[i]) {
                res++;
                i++;
                if (i >= g.length) {
                    break;
                }
            }
        }
        return res;
    }
}
