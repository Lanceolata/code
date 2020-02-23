package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0010_01_Fibonacci {
    public int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        int first = 1, second = 1, tmp;
        for (int i = 3; i <= n; i++) {
            tmp = first + second;
            first = second;
            second = tmp;
        }
        return second;
    }
}
