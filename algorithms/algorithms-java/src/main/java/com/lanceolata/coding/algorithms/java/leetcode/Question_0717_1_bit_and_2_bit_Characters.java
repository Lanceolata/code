package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0717_1_bit_and_2_bit_Characters {
    public boolean isOneBitCharacter(int[] bits) {
        int ones = 0;
        for (int i = bits.length - 2; i >= 0 && bits[i] != 0 ; i--) {
            ones++;
        }
        if (ones % 2 > 0) {
            return false;
        }
        return true;
    }
}
