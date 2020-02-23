package com.lanceolata.coding.algorithms.java.basics.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] arr) {
        shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    protected void sort(T[] arr, int l, int h) {
        if (l >= h) {
            return;
        }
        int j = partition(arr, l, h);
        sort(arr, l, j - 1);
        sort(arr, j + 1, h);
    }

    private int partition(T[] arr, int l, int h) {
        int i = l, j = h + 1;
        T v = arr[l];
        while (true) {
            while (less(arr[++i], v) && i != h) ;
            while (less(v, arr[--j]) && j != l) ;
            if (i >= j)
                break;
            swap(arr, i, j);
        }
        swap(arr, l, j);
        return j;
    }

    private void shuffle(T[] arr) {
        List<Comparable> list = Arrays.asList(arr);
        Collections.shuffle(list);
        list.toArray(arr);
    }
}
