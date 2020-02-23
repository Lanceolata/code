package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0365_Water_and_Jug_Problem {
    public boolean canMeasureWater(int x, int y, int z) {
        return z == 0 || (x + y >= z && z % gcd(x, y) == 0);
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
