package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0066_ConstuctArray {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int[] res = new int[A.length];
        res[0] = 1;
        int tmp = 1;
        for (int i = 1; i < A.length; i++) {
            tmp *= A[i - 1];
            res[i] = tmp;
        }
        tmp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            tmp *= A[i + 1];
            res[i] *= tmp;
        }
        return res;
    }
}
