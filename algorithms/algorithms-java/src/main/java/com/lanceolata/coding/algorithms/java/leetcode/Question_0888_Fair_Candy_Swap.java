package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Question_0888_Fair_Candy_Swap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sum = 0;
        for (int i : aliceSizes) {
            sum += i;
        }
        for (int i : bobSizes) {
            sum -= i;
        }
        int delta = sum / 2;
        Set<Integer> set = new HashSet<>();
        for (int i : aliceSizes) {
            set.add(i);
        }
        for (int i : bobSizes) {
            if (set.contains(i + delta)) {
                return new int[]{i + delta, i};
            }
        }
        return new int[0];
    }
}
