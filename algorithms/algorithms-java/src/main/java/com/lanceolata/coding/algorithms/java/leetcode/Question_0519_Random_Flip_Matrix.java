package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Question_0519_Random_Flip_Matrix {
    private int row;
    private int col;
    private int size;
    private Set<Integer> set;
    private Random random = new Random();

    public Question_0519_Random_Flip_Matrix(int m, int n) {
        this.row = m;
        this.col = n;
        this.size = m * n;
        this.set = new HashSet<>();
    }

    public int[] flip() {
        while (true) {
            int val = random.nextInt(size);
            if (!set.contains(val)) {
                set.add(val);
                return new int[] {val / col, val % col};
            }
        }
    }

    public void reset() {
        set.clear();
    }
}
