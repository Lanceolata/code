package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0088_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        while (n > 0) {
            nums1[--k] = (m > 0 && nums1[m - 1] > nums2[n - 1]) ? nums1[--m] : nums2[--n];
        }
    }
}
