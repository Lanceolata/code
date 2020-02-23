package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0137_Single_Number_II {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0, three = 0;
        for (int n : nums) {
            two |= one & n;
            one ^= n;
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}
