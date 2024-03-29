package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0974_Subarray_Sums_Divisible_by_K {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        count[0] = 1;
        int prefix = 0, res = 0;
        for (int a : nums) {
            prefix = (prefix + a % k + k) % k;
            res += count[prefix]++;
        }
        return res;
    }
}
