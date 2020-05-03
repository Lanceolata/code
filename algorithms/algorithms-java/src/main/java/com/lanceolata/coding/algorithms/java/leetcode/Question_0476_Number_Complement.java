package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0476_Number_Complement {
    public int findComplement(int num) {
        boolean start = false;
        for (int i = 31; i >= 0; i--) {
            if ((num & (1 << i)) != 0) {
                start = true;
            }
            if (start) {
                num ^= 1 << i;
            }
        }
        return num;
    }
}
