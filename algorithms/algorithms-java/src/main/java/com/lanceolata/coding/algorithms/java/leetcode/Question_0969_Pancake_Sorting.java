package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0969_Pancake_Sorting {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int x = arr.length, i; x > 0; --x) {
            for (i = 0; arr[i] != x; ++i) ;
            reverse(arr, i + 1);
            res.add(i + 1);
            reverse(arr, x);
            res.add(x);
        }
        return res;
    }

    private void reverse(int[] A, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
}
