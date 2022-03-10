package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0779_K_th_Symbol_in_Grammar {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        if (k % 2 == 0) {
            return (kthGrammar(n - 1, k / 2) == 0) ? 1 : 0;
        } else {
            return (kthGrammar(n - 1, (k + 1) / 2) == 0) ? 0 : 1;
        }
    }
}
