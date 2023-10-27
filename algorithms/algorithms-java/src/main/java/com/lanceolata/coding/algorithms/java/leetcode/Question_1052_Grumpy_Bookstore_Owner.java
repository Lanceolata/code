package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1052_Grumpy_Bookstore_Owner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0, maxMakeSatisfied = 0;
        for (int i = 0, winOfMakeSatisfied = 0; i < grumpy.length; ++i) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            } else {
                winOfMakeSatisfied += customers[i];
            }
            if (i >= minutes) {
                winOfMakeSatisfied -= grumpy[i - minutes] * customers[i - minutes];
            }
            maxMakeSatisfied = Math.max(winOfMakeSatisfied, maxMakeSatisfied);
        }
        return satisfied + maxMakeSatisfied;
    }
}
