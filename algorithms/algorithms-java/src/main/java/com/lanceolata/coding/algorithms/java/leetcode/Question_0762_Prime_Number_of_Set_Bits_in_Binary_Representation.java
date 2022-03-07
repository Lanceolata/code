package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question_0762_Prime_Number_of_Set_Bits_in_Binary_Representation {
    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        Integer[] arr = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        Set<Integer> primes = new HashSet<>(Arrays.asList(arr));
        for (int i = left; i <= right; i++) {
            int bits = countBits(i);
            if (primes.contains(bits)) {
                res++;
            }
        }
        return res;
    }

    private int countBits(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
}
