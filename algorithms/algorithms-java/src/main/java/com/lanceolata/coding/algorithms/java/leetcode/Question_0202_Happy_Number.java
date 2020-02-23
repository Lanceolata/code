package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Question_0202_Happy_Number {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            n = digitSquareSum(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private int digitSquareSum(int n) {
        int res = 0, tmp;
        while (n != 0) {
            tmp = n % 10;
            res += tmp * tmp;
            n /= 10;
        }
        return res;
    }
}
