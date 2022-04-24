package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0904_Fruit_Into_Baskets {
    public int totalFruit(int[] fruits) {
        int res = 0, cur = 0, count_b = 0, a = 0, b = 0;
        for (int f : fruits) {
            cur = f == a || f == b ? cur + 1 : count_b + 1;
            count_b = f == b ? count_b + 1 : 1;
            if (b != f) {
                a = b;
                b = f;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}
