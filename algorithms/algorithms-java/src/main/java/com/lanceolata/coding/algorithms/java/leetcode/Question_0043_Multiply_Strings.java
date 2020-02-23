package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0043_Multiply_Strings {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return null;
        }
        int m = num1.length(), n = num2.length();
        int[] nums = new int[m + n];
        Arrays.fill(nums, 0);
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int tmp = nums[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                nums[i + j + 1] = tmp % 10;
                nums[i + j] += tmp / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean isValid = false;
        for (int i = 0; i < nums.length; i++) {
            if (isValid || nums[i] != 0) {
                isValid = true;
                sb.append(nums[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
