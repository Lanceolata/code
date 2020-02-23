package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0065_AddTwoNumbers {
    public int Add(int num1,int num2) {
        while (num2 != 0) {
            int tmp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = tmp;
        }
        return num1;
    }
}
