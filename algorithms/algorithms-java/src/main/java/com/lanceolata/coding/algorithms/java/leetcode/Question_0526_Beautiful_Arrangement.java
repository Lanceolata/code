package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0526_Beautiful_Arrangement {
    public int countArrangement(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        return help(0, n, nums);
    }

    private int help(int i, int n, int[] nums) {
        if (i >= n) {
            return 1;
        }
        int res = 0;
        for (int j = i; j < n; j++) {
            if ((i + 1) % nums[j] == 0 || nums[j] % (i + 1) == 0) {
                swap(nums, i, j);
                res += help(i + 1, n, nums);
                swap(nums, i, j);
            }
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
