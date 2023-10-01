package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_1031_Maximum_Sum_of_Two_Non_Overlapping_Subarrays {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        System.out.println(Arrays.toString(prefixSum));
        return Math.max(maxSum(prefixSum, firstLen, secondLen), maxSum(prefixSum, secondLen, firstLen));
    }

    private int maxSum(int[] p, int l, int m) {
        int ans = 0;
        for (int i = l + m, maxL = 0; i < p.length; ++i) {
            maxL = Math.max(maxL, p[i - m] - p[i - m - l]);
            ans = Math.max(ans, maxL + p[i] - p[i - m]);
        }
        return ans;
    }
}
