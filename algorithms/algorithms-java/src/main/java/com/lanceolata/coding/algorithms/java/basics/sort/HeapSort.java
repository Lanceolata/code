package com.lanceolata.coding.algorithms.java.basics.sort;

public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] arr) {
        int n = arr.length - 1;
        // 1. 构建堆
        // k = n / 2 最后一个非叶子节点
        // 从右至左下沉数据
        for (int k = n / 2 - 1; k >= 0; k--) {
            sink(arr, k, n);
        }

        // 排序，将堆顶元素交换到数据尾部
        while (n > 0) {
            swap(arr, 0, n--);
            sink(arr, 0, n);
        }
    }

    private void sink(T[] arr, int k, int n) {
        while (2 * k + 1 <= n) {
            int j = 2 * k + 1;
            // 获得两个子节点中较大的
            if (j < n && less(arr[j], arr[j + 1])) {
                j++;
            }
            // 比较是否小于叶子节点
            if (!less(arr[k], arr[j])) {
                break;
            }
            swap(arr, k, j);
            k = j;
        }
    }
}
