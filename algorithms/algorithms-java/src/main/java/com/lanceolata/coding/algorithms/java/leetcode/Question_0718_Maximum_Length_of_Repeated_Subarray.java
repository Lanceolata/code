package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0718_Maximum_Length_of_Repeated_Subarray {
    public int findLength(int[] nums1, int[] nums2) {
        int res = 0, m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
