package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0477_Total_Hamming_Distance {
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int res = 0, n = nums.length;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                if ((num & (1 << i)) == 0) {
                    cnt++;
                }
            }
            res += cnt * (n - cnt);
        }
        return res;
    }
}
