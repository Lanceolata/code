package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0016_3Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        int res = nums[0] + nums[1] + nums[2];
        int num = Math.abs(res - target);
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int n = nums[i] + nums[l] + nums[r];
                // 注意
                // 判断条件 距离最短
                // 结果 数值
                if (num > Math.abs(n - target)) {
                    res = n;
                    num = Math.abs(n - target);
                }
                if (n < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
