package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0640_Solve_the_Equation {
    public String solveEquation(String equation) {
        String[] lr = equation.split("=");
        int lhs = 0, rhs = 0;
        for (String x : lr[0].split("(?=\\+)|(?=-)")) {
            if (x.contains("x")) {
                lhs += Integer.parseInt(coeff(x));
            } else {
                rhs -= Integer.parseInt(x);
            }
        }
        for (String x : lr[1].split("(?=\\+)|(?=-)")) {
            if (x.contains("x")) {
                lhs -= Integer.parseInt(coeff(x));
            } else {
                rhs += Integer.parseInt(x);
            }
        }
        if (lhs == 0) {
            if (rhs == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }
        return "x=" + rhs / lhs;
    }

    public String coeff(String s) {
        if (s.length() > 1 && s.charAt(s.length() - 2) >= '0' && s.charAt(s.length() - 2) <= '9') {
            return s.replace("x", "");
        }
        return s.replace("x", "1");
    }
}
