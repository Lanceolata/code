package com.lanceolata.coding.algorithms.java.coding_interviews_2;

import java.util.ArrayList;

public class Question_0040_KLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (input == null || k <= 0 || input.length < k) {
            return ret;
        }
        for (int i = input.length / 2 - 1; i >= 0; i--) {
            sink(input, i, k);
        }
        for (int i = k; i < input.length;) {
            if (input[i] < input[0]) {
                swap(input, 0, i);
                sink(input, 0, k);
            } else {
                i++;
            }
        }
        for (int i = 0; i < k; i++) {
            ret.add(input[i]);
        }
        return ret;
    }

    private void sink(int[] nums, int i, int n) {
        while (2 * i + 1 < n) {
            int j = 2 * i + 1;
            if (j + 1 < n && nums[j] < nums[j + 1]) {
                j++;
            }
            if (nums[i] >= nums[j]) {
                break;
            }
            swap(nums, i, j);
            i = j;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
