package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0978_Longest_Turbulent_Subarray {
    public int maxTurbulenceSize(int[] arr) {
        int res = 0, cur = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i >= 2 && ((arr[i - 2] > arr[i - 1] && arr[i - 1] < arr[i]) ||
                    (arr[i - 2] < arr[i - 1] && arr[i - 1] > arr[i]))) {
                cur++;
            } else if (i >= 1 && arr[i - 1] != arr[i]) {
                cur = 2;
            } else {
                cur = 1;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}
