package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0935_Knight_Dialer {
    private static final int MOD = 1000000007;
    private static final int[][] MOVES = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};

    public int knightDialer(int n) {
        if (n == 1) {
            return 10;
        }
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int i = 1; i < n; i++) {
            int[] newArr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            for (int j = 0; j < 10; j++) {
                for (int m : MOVES[j]) {
                    newArr[m] = (newArr[m] + arr[j]) % MOD;
                }
            }
            arr = newArr;
        }
        long res = 0;
        for (long i : arr) {
            res += i;
        }
        return (int) (res % MOD);
    }
}
