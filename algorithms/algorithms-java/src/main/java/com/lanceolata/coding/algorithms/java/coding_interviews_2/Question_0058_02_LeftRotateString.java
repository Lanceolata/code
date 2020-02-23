package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0058_02_LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() <= 0 || n < 0) {
            return "";
        }
        int len = str.length();
        n = n % len;
        char[] arr = str.toCharArray();
        reverse(arr, 0, n - 1);
        reverse(arr, n, len - 1);
        reverse(arr, 0, len - 1);
        return new String(arr);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char c = arr[l];
            arr[l] = arr[r];
            arr[r] = c;
            l++; r--;
        }
    }
}
