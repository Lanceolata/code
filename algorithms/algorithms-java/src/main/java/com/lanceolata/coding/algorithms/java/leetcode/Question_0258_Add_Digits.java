package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0258_Add_Digits {
    public int addDigits(int num) {
        return num == 0 ? 0 : (num - 1) % 9 + 1;
    }
}
