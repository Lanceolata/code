package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Random;

public class Question_0384_Shuffle_an_Array {

    private int[] nums;
    private Random random;

    public Question_0384_Shuffle_an_Array(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = nums.clone();
        for (int i = 0; i < res.length; i++) {
            swapAt(res, i, randRange(i, res.length));
        }
        return res;
    }

    private int randRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    private void swapAt(int[] res, int i, int j) {
        int temp = res[i];
        res[i] = res[j];
        res[j] = temp;
    }
}
