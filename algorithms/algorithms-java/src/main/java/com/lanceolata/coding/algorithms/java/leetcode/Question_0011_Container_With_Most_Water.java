package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0011_Container_With_Most_Water {
    public int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }
        int res = 0, l = 0, r = height.length - 1;
        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
