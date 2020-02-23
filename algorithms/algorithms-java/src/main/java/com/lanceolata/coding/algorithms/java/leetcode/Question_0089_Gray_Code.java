package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0089_Gray_Code {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        int num = 1;
        for (int i = 1; i <= n; i++) {
            num <<= 1;
        }
        for (int i = 0; i < num; i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }
}
