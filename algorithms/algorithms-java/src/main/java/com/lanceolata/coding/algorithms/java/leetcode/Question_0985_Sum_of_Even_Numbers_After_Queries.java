package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0985_Sum_of_Even_Numbers_After_Queries {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        int sum = 0;
        for (int n : nums) {
            if ((n & 1) == 0) {
                sum += n;
            }
        }
        for (int j = 0; j < queries.length; j++) {
            int i = queries[j][1], v = queries[j][0];
            if ((nums[i] & 1) == 0) {
                sum -= nums[i];
            }
            nums[i] += v;
            if ((nums[i] & 1) == 0) {
                sum += nums[i];
            }
            res[j] = sum;
        }
        return res;
    }
}
