package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0509_Fibonacci_Number {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 3) {
            return 1;
        }
        int first = 1, second = 1, tmp;
        for (int i = 2; i < n; i++) {
            tmp = first + second;
            first = second;
            second = tmp;
        }
        return second;
    }
}
