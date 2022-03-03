package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0738_Monotone_Increasing_Digits {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] arr = s.toCharArray();
        int index = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                index = i;
                arr[i - 1] -= 1;
            }
        }
        for(int i = index; i < arr.length; i ++) {
            arr[i] = '9';
        }
        return Integer.parseInt(new String(arr));
    }
}
