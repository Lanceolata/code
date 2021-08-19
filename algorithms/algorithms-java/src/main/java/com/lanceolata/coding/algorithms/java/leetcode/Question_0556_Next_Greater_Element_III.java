package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0556_Next_Greater_Element_III {
    public int nextGreaterElement(int n) {
        char[] number = (n + "").toCharArray();
        int i = number.length - 1;
        for (; i > 0; i--) {
            if (number[i] > number[i - 1]) {
                break;
            }
        }
        if (i == 0) {
            return -1;
        }
        for (int j = number.length - 1; j >= i; j--) {
            if (number[j] > number[i - 1]) {
                swap(number, j, i - 1);
                break;
            }
        }
        Arrays.sort(number, i, number.length);
        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }

    private void swap(char[] number, int i, int j) {
        char tmp = number[i];
        number[i] = number[j];
        number[j] = tmp;
    }
}
