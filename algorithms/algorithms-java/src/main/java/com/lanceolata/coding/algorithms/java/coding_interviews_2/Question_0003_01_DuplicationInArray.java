package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0003_01_DuplicationInArray {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || length <= 1) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int tmp = numbers[i];
                numbers[i] = numbers[tmp];
                numbers[tmp] = tmp;
            }
        }
        return false;
    }
}
