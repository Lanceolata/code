package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0043_NumberOf1 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0, high = 0, cur = 0, low = 0;
        for (int i = 1; i <= n; i *= 10) {
            high = n / (i * 10);
            cur = (n / i) % 10;
            low = n % i;
            if (cur == 0) {
                count += high * i;
            } else if (cur == 1) {
                count += high * i + low + 1;
            } else {
                count += (high + 1) * i;
            }
        }
        return count;
    }
}
