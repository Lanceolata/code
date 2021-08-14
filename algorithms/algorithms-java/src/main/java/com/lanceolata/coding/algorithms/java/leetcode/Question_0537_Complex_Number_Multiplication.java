package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.stream.Stream;

public class Question_0537_Complex_Number_Multiplication {
    public String complexNumberMultiply(String num1, String num2) {
        int[] coefs1 = Stream.of(num1.split("\\+|i")).mapToInt(Integer::parseInt).toArray(),
                coefs2 = Stream.of(num2.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
        return (coefs1[0] * coefs2[0] - coefs1[1] * coefs2[1]) + "+" + (coefs1[0] * coefs2[1] + coefs1[1] * coefs2[0]) + "i";
    }
}
