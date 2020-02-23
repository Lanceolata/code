package com.lanceolata.coding.algorithms.java.basics.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeWayQuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] arr) {
        shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    private void sort(T[] arr, int l, int h) {
        if (l >= h) {
            return;
        }
        int lt = l, i = l + 1, gt = h;
        T v = arr[l];
        while (i <= gt) {
            int cmp = arr[i].compareTo(v);
            if (cmp < 0) {
                swap(arr, lt++, i);
            } else if (cmp > 0) {
                swap(arr, i, gt--);
            } else {
                i++;
            }
        }
        sort(arr, l, lt - 1);
        sort(arr, gt + 1, h);
    }

    private void shuffle(T[] arr) {
        List<Comparable> list = Arrays.asList(arr);
        Collections.shuffle(list);
        list.toArray(arr);
    }
}
