package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0771_Jewels_and_Stones {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] isJewels = new boolean[256];
        Arrays.fill(isJewels, false);
        for (char c: jewels.toCharArray()) {
            isJewels[c] = true;
        }
        int res = 0;
        for (char c : stones.toCharArray()) {
            if (isJewels[c]) {
                res++;
            }
        }
        return res;
    }
}
