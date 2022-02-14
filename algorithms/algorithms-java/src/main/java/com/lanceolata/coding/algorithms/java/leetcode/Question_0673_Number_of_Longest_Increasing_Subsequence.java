package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0673_Number_of_Longest_Increasing_Subsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, maxLen = 0;
        int[] lens = new int[n], cnts = new int[n];
        Arrays.fill(lens, 1);
        Arrays.fill(cnts, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) {
                    continue;
                }
                if (lens[i] == lens[j] + 1) {
                    cnts[i] += cnts[j];
                }
                if (lens[i] < lens[j] + 1) {
                    lens[i] = lens[j] + 1;
                    cnts[i] = cnts[j];
                }
            }
            if (maxLen == lens[i]) {
                res += cnts[i];
            }
            if (maxLen < lens[i]) {
                maxLen = lens[i];
                res = cnts[i];
            }
        }
        return res;
    }
}
