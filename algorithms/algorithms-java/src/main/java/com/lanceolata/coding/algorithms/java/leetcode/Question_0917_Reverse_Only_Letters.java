package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0917_Reverse_Only_Letters {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isAlphabetic(arr[i])) {
                i++;
            }
            while (i < j && !Character.isAlphabetic(arr[j])) {
                j--;
            }
            if (i < j) {
                char c = arr[i];
                arr[i] = arr[j];
                arr[j] = c;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}
