package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_1073_Adding_Two_Negabinary_Numbers {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> res = new ArrayList<>();
        int carry = 0, i = arr1.length - 1, j = arr2.length - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            carry += i >= 0 ? arr1[i--] : 0;
            carry += j >= 0 ? arr2[j--] : 0;
            res.add(carry & 1);
            carry = -(carry >> 1);
        }
        while (res.size() > 1 && res.get(res.size() - 1) == 0) {
            res.remove(res.size() - 1);
        }
        int[] arr = new int[res.size()];
        for (i = 0; i < arr.length; i++) {
            arr[i] = res.get(arr.length - i - 1);
        }
        return arr;
    }
}
