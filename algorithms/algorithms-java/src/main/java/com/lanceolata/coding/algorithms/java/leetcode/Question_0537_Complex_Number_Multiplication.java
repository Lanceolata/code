package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0537_Complex_Number_Multiplication {
    public String complexNumberMultiply(String num1, String num2) {
        String a = num1.substring(0, num1.indexOf(String.valueOf('+')));
        String b = num1.substring(num1.indexOf('+') + 1, num1.indexOf('i'));
        String c = num2.substring(0, num2.indexOf('+'));
        String d = num2.substring(num2.indexOf('+') + 1, num2.indexOf('i'));
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        int z = Integer.parseInt(c);
        int v = Integer.parseInt(d);
        int sum1 = x * z - y * v;
        int sum2 = x * v + y * z;
        StringBuilder sb = new StringBuilder();
        sb.append(sum1).append("+").append(sum2).append("i");
        return sb.toString();
    }
}
