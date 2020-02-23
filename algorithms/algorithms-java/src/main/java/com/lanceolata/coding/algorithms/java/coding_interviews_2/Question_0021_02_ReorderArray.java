package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0021_02_ReorderArray {
    public void reOrderArray(int [] array) {
        if (array == null) {
            return;
        }
        boolean isOrdered = false;
        for (int i = array.length - 1; i > 0 && !isOrdered; i--) {
            isOrdered = true;
            for (int j = 0; j < i; j++) {
                if (!isOdd(array[j]) && isOdd(array[j + 1])) {
                    isOrdered = false;
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
    
    private boolean isOdd(int n) {
        return (n & 1) != 0;
    }
}
