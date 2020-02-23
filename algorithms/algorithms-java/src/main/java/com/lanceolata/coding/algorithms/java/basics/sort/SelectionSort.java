package com.lanceolata.coding.algorithms.java.basics.sort;

public class SelectionSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(arr[j], arr[i])) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }
}
