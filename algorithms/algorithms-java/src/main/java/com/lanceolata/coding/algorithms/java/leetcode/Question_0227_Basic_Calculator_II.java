package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0227_Basic_Calculator_II {
    public int calculate(String s) {
        int res = 0, cur = 0, num = 0, n = s.length();
        char op = '+';
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == n - 1) {
                switch (op) {
                case '+':
                    cur += num;
                    break;
                case '-':
                    cur -= num;
                    break;
                case '*':
                    cur *= num;
                    break;
                case '/':
                    cur /= num;
                    break;
                }
                if (c == '+' || c == '-' || i == n - 1) {
                    res += cur;
                    cur = 0;
                }
                op = c;
                num = 0;
            }
        }
        return res;
    }
}
