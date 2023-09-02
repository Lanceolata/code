package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1009_Complement_of_Base_10_Integer {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        boolean start = false;
        for (int i = 31; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                start = true;
            }
            if (start) {
                n ^= 1 << i;
            }
        }
        return n;
    }
}
