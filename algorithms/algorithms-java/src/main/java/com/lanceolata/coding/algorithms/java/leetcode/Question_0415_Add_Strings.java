package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0415_Add_Strings {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            carry += i >= 0 ? num1.charAt(i--) - '0' : 0;
            carry += j >= 0 ? num2.charAt(j--) - '0' : 0;
            res.append(carry % 10);
            carry /= 10;
        }
        return res.reverse().toString();
    }
}
