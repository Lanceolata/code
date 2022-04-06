package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0869_Reordered_Power_of_2 {
    public boolean reorderedPowerOf2(int n) {
        long c = counter(n);
        for (int i = 0; i < 32; i++) {
            if (counter(1 << i) == c) {
                return true;
            }
        }
        return false;
    }

    private long counter(int n) {
        long res = 0;
        for (; n > 0; n /= 10) {
            res += (int) Math.pow(10, n % 10);
        }
        return res;
    }

    public boolean reorderedPowerOf2_v2(int n) {
        int[] arr = count_v2(n);
        for (int i = 0; i < 31; ++i) {
            if (Arrays.equals(arr, count_v2(1 << i))) {
                return true;
            }
        }
        return false;
    }

    public int[] count_v2(int n) {
        int[] res = new int[10];
        while (n > 0) {
            res[n % 10]++;
            n /= 10;
        }
        return res;
    }
}
