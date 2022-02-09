package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question_0658_Find_K_Closest_Elements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - k, m;
        while (l < r) {
            m = l + (r - l) / 2;
            if (x - arr[m] > arr[m + k] - x) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return Arrays.stream(arr, l, l + k).boxed().collect(Collectors.toList());
    }
}
