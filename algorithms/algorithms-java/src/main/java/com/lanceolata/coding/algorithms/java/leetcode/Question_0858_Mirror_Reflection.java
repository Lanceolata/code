package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0858_Mirror_Reflection {
    public int mirrorReflection(int p, int q) {
        while (p % 2 == 0 && q % 2 == 0) {
            p >>= 1;
            q >>= 1;
        }
        return 1 - p % 2 + q % 2;
    }
}
