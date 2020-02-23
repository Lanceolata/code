package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0064_Accumulate {
    public int Sum_Solution(int n) {
        boolean flag = (n > 0) && ((n += Sum_Solution(n - 1)) > 0);
        return n;
    }
}
