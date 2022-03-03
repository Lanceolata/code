package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0728_Self_Dividing_Numbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList();
        for (int n = left; n <= right; ++n) {
            if (selfDividing(n)) {
                res.add(n);
            }
        }
        return res;
    }

    public boolean selfDividing(int n) {
        for (char c : String.valueOf(n).toCharArray()) {
            if (c == '0' || (n % (c - '0') > 0)) {
                return false;
            }
        }
        return true;
    }
}
