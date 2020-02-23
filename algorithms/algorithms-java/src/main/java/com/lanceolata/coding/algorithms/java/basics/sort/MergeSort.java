package com.lanceolata.coding.algorithms.java.basics.sort;

public class MergeSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] arr) {
        T[] copy = (T[]) new Comparable[arr.length];
        sort(arr, copy, 0, arr.length - 1);
    }

    private void sort(T[] arr, T[] copy, int l, int h) {
        if (h <= l) {
            return;
        }
        int mid = l + (h - l) / 2;
        sort(arr, copy, l, mid);
        sort(arr, copy, mid + 1, h);
        merge(arr, copy, l, mid, h);
    }

    private void merge(T[] arr, T[] copy, int l, int m, int h) {
        for (int i = l; i <= h; i++) {
            copy[i] = arr[i];
        }
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= h) {
            if (!less(copy[j], copy[i])) {
                arr[k++] = copy[i++];
            } else {
                arr[k++] = copy[j++];
            }
        }
        while (i <= m) {
            arr[k++] = copy[i++];
        }
        while (j <= m) {
            arr[k++] = copy[j++];
        }
    }
}
