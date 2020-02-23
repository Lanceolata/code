package com.lanceolata.coding.algorithms.java.basics.sort;

public class InsertionSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (less(arr[j - 1], arr[j])) {
                    break;
                }
                swap(arr, j - 1, j);
            }
        }
    }
}
