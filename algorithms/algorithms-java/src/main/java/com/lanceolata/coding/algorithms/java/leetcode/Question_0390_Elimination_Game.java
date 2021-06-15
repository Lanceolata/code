package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0390_Elimination_Game {
    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n, step = 1, head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }
}
