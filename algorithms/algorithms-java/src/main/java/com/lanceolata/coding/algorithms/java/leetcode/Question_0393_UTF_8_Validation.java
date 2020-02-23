package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0393_UTF_8_Validation {
    public boolean validUtf8(int[] data) {
        int cnt = 0;
        for (int i : data) {
            if (cnt == 0) {
                if ((i >> 5) == 0b110) {
                    cnt = 1;
                } else if ((i >> 4) == 0b1110) {
                    cnt = 2;
                } else if ((i >> 3) == 0b11110) {
                    cnt = 3;
                } else if ((i >> 7) != 0) {
                    return false;
                }
            } else {
                if ((i >> 6) != 0b10) {
                    return false;
                }
                cnt--;
            }
        }
        return cnt == 0;
    }
}
