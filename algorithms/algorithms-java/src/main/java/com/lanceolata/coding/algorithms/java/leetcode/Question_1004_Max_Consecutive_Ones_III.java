package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1004_Max_Consecutive_Ones_III {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                k--;
            }
            if (k < 0) {
               if (nums[i] == 0) {
                   k++;
               }
               i++;
            }
            j++;
        }
        return j - i;
    }
}
