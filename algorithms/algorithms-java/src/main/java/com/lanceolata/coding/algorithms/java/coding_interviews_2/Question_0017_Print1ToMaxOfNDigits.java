package com.lanceolata.coding.algorithms.java.coding_interviews_2;

import java.util.Arrays;

public class Question_0017_Print1ToMaxOfNDigits {
    public void Print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] s = new char[n];
        Arrays.fill(s, '0');
        help(n, 0, s);
    }

    private void help(int n, int i, char[] s) {
        if (i >= n) {
            System.out.println(new String(s));
            return;
        }
        for (char j = '0'; j <= '9'; j++) {
            s[i] = j;
            help(n, i + 1, s);
        }
    }
}
