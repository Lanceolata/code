package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0396_Rotate_Function {
    public int maxRotateFunction(int[] A) {
        long sum = 0, F = 0;
        for (int i = 0; i < A.length; i++) {
            F += i * A[i];
            sum += A[i];
        }
        long res = F;
        for (int i = A.length - 1; i >= 1; i--) {
            F = F + sum - A.length * A[i];
            res = Math.max(res, F);
        }
        return (int)res;
    }
}
