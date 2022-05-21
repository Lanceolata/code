package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question_0989_Add_to_Array_Form_of_Integer {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int i = num.length - 1, carry = 0;
        while (i >= 0 || k > 0 || carry > 0) {
            carry += (i >= 0 ? num[i--] : 0) + (k > 0 ? k % 10 : 0);
            res.add(carry % 10);
            carry /= 10;
            k /= 10;
        }
        Collections.reverse(res);
        return res;
    }
}
