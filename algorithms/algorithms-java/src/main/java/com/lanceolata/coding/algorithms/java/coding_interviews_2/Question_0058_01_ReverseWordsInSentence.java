package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0058_01_ReverseWordsInSentence {
    public String ReverseSentence(String str) {
        if (str == null) {
            return null;
        }
        char[] arr = str.toCharArray();
        for (int i = 0, j = 0; j <= arr.length; j++) {
            if (j == arr.length || arr[j] == ' ') {
                reverse(arr, i, j - 1);
                i = j + 1;
            }
        }
        reverse(arr, 0, arr.length - 1);
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
