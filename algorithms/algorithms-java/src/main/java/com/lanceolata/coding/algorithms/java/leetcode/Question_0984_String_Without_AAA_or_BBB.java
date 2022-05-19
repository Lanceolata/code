package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0984_String_Without_AAA_or_BBB {
    public String strWithout3a3b(int a, int b) {
        StringBuilder res = new StringBuilder();
        while (a > 0 || b > 0) {
            boolean flag = false;
            int l = res.length();
            if (l >= 2 && res.charAt(l - 1) == res.charAt(l - 2)) {
                if (res.charAt(l - 1) == 'b') {
                    flag = true;
                }
            } else {
                if (a >= b) {
                    flag = true;
                }
            }
            if (flag) {
                a--;
                res.append('a');
            } else {
                b--;
                res.append('b');
            }
        }
        return res.toString();
    }
}
