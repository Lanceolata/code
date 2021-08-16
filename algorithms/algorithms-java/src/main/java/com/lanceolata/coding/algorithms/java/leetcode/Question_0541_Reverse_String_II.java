package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0541_Reverse_String_II {
    public String reverseStr(String s, int k) {
        if (s == null || s.isEmpty() || k <= 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length;) {
            int l = i, r = Math.min(i + k - 1, arr.length - 1);
            while (l < r) {
                char tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l++;
                r--;
            }
            i += 2 * k;
        }
        return new String(arr);
    }
}
