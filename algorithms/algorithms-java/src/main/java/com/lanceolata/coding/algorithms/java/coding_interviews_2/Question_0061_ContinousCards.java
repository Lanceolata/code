package com.lanceolata.coding.algorithms.java.coding_interviews_2;

import java.util.Arrays;

public class Question_0061_ContinousCards {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        int gap = 0, zero = 0, i = 0;
        Arrays.sort(numbers);
        for (i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                zero++;
            } else if (numbers[i] == numbers[i + 1]) {
                return false;
            } else {
                gap += numbers[i + 1] - numbers[i] - 1;
            }
        }
        return zero >= gap;
    }
}
