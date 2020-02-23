package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0021_01_ReorderArray {
    public void reOrderArray(int [] array) {
        if (array == null) {
            return;
        }
        int l = 0, r = array.length - 1;
        while (l < r) {
            while (l < r && isOdd(array[l])) {
                l++;
            }
            while (l < r && !isOdd(array[r])) {
                r--;
            }
            if (l < r) {
                int tmp = array[l];
                array[l] = array[r];
                array[r] = tmp;
            }
        }
    }

    private boolean isOdd(int n) {
        return (n & 1) != 0;
    }
}
