package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0060_Permutation_Sequence {
    public String getPermutation(int n, int k) {
        int nums[] = new int[n];
        int pCount = 1;
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            pCount *= i + 1;
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            pCount /= n - i;
            int select = k / pCount;
            sb.append(String.valueOf(nums[select]));

            for(int j = select; j < n - i - 1; j++) {
                nums[j] = nums[j + 1];
            }
            k = k % pCount;
        }
        return sb.toString();
    }
}
