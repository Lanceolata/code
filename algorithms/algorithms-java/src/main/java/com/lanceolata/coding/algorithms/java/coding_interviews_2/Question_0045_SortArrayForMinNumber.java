package com.lanceolata.coding.algorithms.java.coding_interviews_2;

import java.util.Arrays;
import java.util.Comparator;

public class Question_0045_SortArrayForMinNumber {
    private class MinNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order1.compareTo(order2);
        }
    }

    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return "";
        }
        String[] asStrs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            asStrs[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(asStrs, new MinNumberComparator());

        if (asStrs[0].equals("0")) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        for (String numAsStr : asStrs) {
            res.append(numAsStr);
        }

        return res.toString();
    }
}
