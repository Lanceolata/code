package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Random;

public class Question_0384_Shuffle_an_Array {

    private int[] array;
    private int[] original;
    private Random rand = new Random();

    public Question_0384_Shuffle_an_Array(int[] nums) {
        this.array = nums;
        this.original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
