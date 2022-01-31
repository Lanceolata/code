package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0646_Maximum_Length_of_Pair_Chain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE, res = 0;
        for (int[] pair: pairs) {
            if (cur < pair[0]) {
                cur = pair[1];
                res++;
            }
        }
        return res;
    }
}
