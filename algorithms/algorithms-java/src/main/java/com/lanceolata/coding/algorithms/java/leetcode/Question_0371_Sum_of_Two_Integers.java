package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0371_Sum_of_Two_Integers {
    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = a ^ b;
            b = (a & b) << 1;
            a = tmp;
        }
        return a;
    }
}
