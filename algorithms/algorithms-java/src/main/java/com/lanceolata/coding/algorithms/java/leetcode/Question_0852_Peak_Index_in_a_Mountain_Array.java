package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0852_Peak_Index_in_a_Mountain_Array {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1, m;
        while (l < r) {
            m = l + (r - l) / 2;
            if (arr[m] < arr[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
