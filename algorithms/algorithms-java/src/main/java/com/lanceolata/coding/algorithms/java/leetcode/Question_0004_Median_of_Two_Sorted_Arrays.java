package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0004_Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (((m + n) & 1) == 1) {
            return help(nums1, nums2, 0, 0, (m + n + 1) / 2);
        } else {
            return (help(nums1, nums2, 0, 0, (m + n + 1) / 2) + help(nums1, nums2, 0, 0, (m + n + 2) / 2)) / 2.0;
        }
    }

    private int help(int[] nums1, int[] nums2, int i, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int v1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int v2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (v1 < v2) {
            return help(nums1, nums2, i + k / 2, j, k - k / 2);
        } else {
            return help(nums1, nums2, i, j + k / 2, k - k / 2);
        }
    }
}
