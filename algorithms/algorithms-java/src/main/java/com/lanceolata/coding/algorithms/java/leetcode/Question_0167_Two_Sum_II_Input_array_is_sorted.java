package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0167_Two_Sum_II_Input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) {
            return null;
        }
        int l = 0, r = numbers.length - 1, num;
        while (l < r) {
            num = numbers[l] + numbers[r];
            if (num == target) {
                return new int[] { l + 1, r + 1 };
            } else if (num < target) {
                l++;
            } else {
                r--;
            }
        }
        return null;
    }
}
