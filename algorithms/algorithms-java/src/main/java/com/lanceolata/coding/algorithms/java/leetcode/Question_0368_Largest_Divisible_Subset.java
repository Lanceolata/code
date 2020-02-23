package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_0368_Largest_Divisible_Subset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length], parent = new int[nums.length];
        int mx = 0, mxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                    if (dp[i] > mx) {
                        mx = dp[i];
                        mxIndex = i;
                    }
                }
            }
        }
        for (int i = 0; i < mx; i++) {
            res.add(nums[mxIndex]);
            mxIndex = parent[mxIndex];
        }
        return res;
    }
}
