package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0900_RLE_Iterator {
    private int index;
    private int[] encoding;

    public Question_0900_RLE_Iterator(int[] encoding) {
        this.encoding = encoding;
        this.index = 0;
    }

    public int next(int n) {
        while (index < encoding.length && n > encoding[index]) {
            n = n - encoding[index];
            index += 2;
        }
        if (index >= encoding.length) {
            return -1;
        }
        encoding[index] = encoding[index] - n;
        return encoding[index + 1];
    }
}
