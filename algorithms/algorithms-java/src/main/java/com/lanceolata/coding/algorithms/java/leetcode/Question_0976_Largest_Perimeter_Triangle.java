package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0976_Largest_Perimeter_Triangle {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 1; --i) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
