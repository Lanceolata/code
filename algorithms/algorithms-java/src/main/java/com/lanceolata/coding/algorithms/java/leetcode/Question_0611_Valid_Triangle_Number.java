package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0611_Valid_Triangle_Number {
    public int triangleNumber(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int k = nums.length - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    res += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return res;
    }
}
