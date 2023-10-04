package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1035_Uncrossed_Lines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] dp = new int[n2 + 1], dpPrev = new int[n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = 1 + dpPrev[j - 1];
                } else {
                    dp[j] = Math.max(dp[j - 1], dpPrev[j]);
                }
            }
            dpPrev = dp.clone();
        }
        return dp[n2];
    }
}
