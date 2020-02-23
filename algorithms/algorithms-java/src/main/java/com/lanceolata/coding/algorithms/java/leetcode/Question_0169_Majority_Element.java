package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0169_Majority_Element {
    public int majorityElement(int[] nums) {
        int res = nums[0], cnt = 0;
        for (int n : nums) {
            if (cnt == 0) {
                res = n;
                cnt = 1;
            } else if (res == n) {
                cnt++;
            } else {
                cnt--;
            }
        }
        cnt = 0;
        for (int i : nums) {
            if (i == res) {
                cnt++;
            }
        }
        return (cnt <= nums.length / 2) ? -1 : res;
    }
}
