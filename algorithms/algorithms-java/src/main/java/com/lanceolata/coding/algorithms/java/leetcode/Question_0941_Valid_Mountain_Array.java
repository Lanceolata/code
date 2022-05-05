package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0941_Valid_Mountain_Array {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int i = 0;
        while (i + 1 < arr.length && arr[i] < arr[i + 1]) {
            i++;
        }
        if (i == 0 || i == arr.length - 1) {
            return false;
        }
        while (i + 1 < arr.length && arr[i] > arr[i + 1]) {
            i++;
        }
        return i == arr.length - 1;
    }
}
