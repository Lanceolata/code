package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0075_Sort_Colors {
    public void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }
        int one = -1, two = -1, three = -1;
        for (int n : nums) {
            if (n == 0) {
                nums[++three] = 2;
                nums[++two] = 1;
                nums[++one] = 0;
            } else if (n == 1) {
                nums[++three] = 2;
                nums[++two] = 1;
            } else {
                nums[++three] = 2;
            }
        }
    }
}
