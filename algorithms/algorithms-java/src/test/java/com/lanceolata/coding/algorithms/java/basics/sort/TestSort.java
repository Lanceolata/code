package com.lanceolata.coding.algorithms.java.basics.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestSort {
    private Integer[][] input = {
            {9, 8, 7, 6, 5, 4, 3, 2, 1},
            {1, 2, 3, 4, 5, 6, 7, 8, 9}
    };
    private Integer[][] output = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9}
    };

    private Integer[] testSort(Sort<Integer> sort, Integer[] input) {
        Integer[] copy = Arrays.copyOf(input, input.length);
        sort.sort(copy);
        return copy;
    }

    @Test
    public void testBubbleSort() {
        Sort<Integer> sort = new BubbleSort<>();
        for (int i = 0; i < input.length; i++) {
            Integer[] result = testSort(sort, input[i]);
            Assert.assertArrayEquals(result, output[i]);
        }
    }

    @Test
    public void testHeapSort() {
        Sort<Integer> sort = new HeapSort<>();
        for (int i = 0; i < input.length; i++) {
            Integer[] result = testSort(sort, input[i]);
            Assert.assertArrayEquals(result, output[i]);
        }
    }

    @Test
    public void testInsertionSort() {
        Sort<Integer> sort = new InsertionSort<>();
        for (int i = 0; i < input.length; i++) {
            Integer[] result = testSort(sort, input[i]);
            Assert.assertArrayEquals(result, output[i]);
        }
    }

    @Test
    public void testMergeSort() {
        Sort<Integer> sort = new MergeSort<>();
        for (int i = 0; i < input.length; i++) {
            Integer[] result = testSort(sort, input[i]);
            Assert.assertArrayEquals(result, output[i]);
        }
    }

    @Test
    public void testQuickSort() {
        Sort<Integer> sort = new QuickSort<>();
        for (int i = 0; i < input.length; i++) {
            Integer[] result = testSort(sort, input[i]);
            Assert.assertArrayEquals(result, output[i]);
        }
    }

    @Test
    public void testSelectionSort() {
        Sort<Integer> sort = new SelectionSort<>();
        for (int i = 0; i < input.length; i++) {
            Integer[] result = testSort(sort, input[i]);
            Assert.assertArrayEquals(result, output[i]);
        }
    }

    @Test
    public void testShellSort() {
        Sort<Integer> sort = new ShellSort<>();
        for (int i = 0; i < input.length; i++) {
            Integer[] result = testSort(sort, input[i]);
            Assert.assertArrayEquals(result, output[i]);
        }
    }

    @Test
    public void testThreeWayQuickSort() {
        Sort<Integer> sort = new ThreeWayQuickSort<>();
        for (int i = 0; i < input.length; i++) {
            Integer[] result = testSort(sort, input[i]);
            Assert.assertArrayEquals(result, output[i]);
        }
    }
}
