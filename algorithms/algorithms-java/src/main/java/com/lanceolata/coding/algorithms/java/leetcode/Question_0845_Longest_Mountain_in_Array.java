package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0845_Longest_Mountain_in_Array {
    public int longestMountain(int[] arr) {
        int n = arr.length, res = 0;
        for (int i = 0; i < n; ) {
            int j = i;
            while (j + 1 < n && arr[j] < arr[j + 1]) {
                j++;
            }
            int k = j;
            while (j != i && j + 1 < n && arr[j] > arr[j + 1]) {
                j++;
            }
            if (j != i && j != k) {
                res = Math.max(res, j - i + 1);
            }
            i = Math.max(i + 1, j);
        }
        return res;
    }
}
