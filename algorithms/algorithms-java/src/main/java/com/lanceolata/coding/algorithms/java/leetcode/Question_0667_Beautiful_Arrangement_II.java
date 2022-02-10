package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0667_Beautiful_Arrangement_II {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int i = 0;
        for (int j = 1; j < n - k; j++) {
            res[i++] = j;
        }
        for (int j = 0; j <= k; j++) {
            res[i++] = (j % 2 == 0) ? (n - k + j / 2) : (n - j / 2);
        }
        return res;
    }
}
