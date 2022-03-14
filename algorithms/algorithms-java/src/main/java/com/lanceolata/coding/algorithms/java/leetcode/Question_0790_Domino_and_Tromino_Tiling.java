package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0790_Domino_and_Tromino_Tiling {
    public int numTilings(int n) {
        int MOD = 1_000_000_007;
        if (n <= 2) {
            return n;
        }
        long fPrevious = 1L, fCurrent = 2L, pCurrent = 1L;
        for (int k = 3; k < n + 1; ++k) {
            long tmp = fCurrent;
            fCurrent = (fCurrent + fPrevious + 2 * pCurrent) % MOD;
            pCurrent = (pCurrent + fPrevious) % MOD;
            fPrevious = tmp;
        }
        return (int) (fCurrent);
    }
}
