package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0067_Add_Binary {
    public String addBinary(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) {
            return a.isEmpty() ? b : a;
        }
        int count = 0, i = a.length() - 1, j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || count == 1) {
            count += i >= 0 ? a.charAt(i--) - '0' : 0;
            count += j >= 0 ? b.charAt(j--) - '0' : 0;
            sb.append(count % 2);
            count /= 2;
        }
        return sb.reverse().toString();
    }
}
