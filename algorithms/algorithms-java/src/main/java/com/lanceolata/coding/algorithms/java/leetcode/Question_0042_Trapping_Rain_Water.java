package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0042_Trapping_Rain_Water {
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        int res = 0, l = 0, lmax = 0, r = height.length - 1, rmax = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] > lmax) {
                    lmax = height[l];
                } else {
                    res += lmax - height[l];
                }
                l++;
            } else {
                if (height[r] > rmax) {
                    rmax = height[r];
                } else {
                    res += rmax - height[r];
                }
                r--;
            }
        }
        return res;
    }
}
