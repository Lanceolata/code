package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;

public class Question_0166_Fraction_to_Recurring_Decimal {
    public String fractionToDecimal(int numerator, int denominator) {
        // 分母为0
        if (denominator == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sb.append("-");
        }
        long numerator1 = Math.abs((long) numerator);
        long denominator1 = Math.abs((long) denominator);
        long quotien = numerator1 / denominator1;
        long reminder = numerator1 % denominator1;
        sb.append(quotien);
        if (reminder == 0)
            return sb.toString();
        sb.append(".");
        int i = sb.length();
        HashMap<Long, Integer> map = new HashMap<>();
        while (reminder != 0) {
            if (map.containsKey(reminder)) {
                int index = map.get(reminder);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }
            map.put(reminder, i);
            sb.append(reminder * 10 / denominator1);
            reminder = reminder * 10 % denominator1;
            i++;
        }
        return sb.toString();
    }
}
