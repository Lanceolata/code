package com.lanceolata.coding.algorithms.java.basics.sort;

public class BubbleSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] arr) {
        int n = arr.length;
        boolean isSorted = false;
        for (int i = n - 1; i > 0 && !isSorted; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (less(arr[j + 1], arr[j])) {
                    isSorted = false;
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}
