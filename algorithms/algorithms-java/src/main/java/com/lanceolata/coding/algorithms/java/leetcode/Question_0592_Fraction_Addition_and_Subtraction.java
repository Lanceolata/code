package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0592_Fraction_Addition_and_Subtraction {
    public String fractionAddition(String expression) {
        List<Character> sign = new ArrayList<>();
        if (expression.charAt(0) != '-') {
            sign.add('+');
        }
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign.add(expression.charAt(i));
            }
        }
        int prevNum = 0, prevDen = 1, i = 0;
        for (String sub : expression.split("(\\+)|(-)")) {
            if (sub.length() > 0) {
                String[] fraction = sub.split("/");
                int num = Integer.parseInt(fraction[0]);
                int den = Integer.parseInt(fraction[1]);
                int g = Math.abs(gcd(den, prevDen));
                if (sign.get(i++) == '+') {
                    prevNum = prevNum * den / g + num * prevDen / g;
                } else {
                    prevNum = prevNum * den / g - num * prevDen / g;
                }
                prevDen = den * prevDen / g;
                g = Math.abs(gcd(prevDen, prevNum));
                prevNum /= g;
                prevDen /= g;
            }
        }
        return prevNum + "/" + prevDen;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
