package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Question_0898_Bitwise_ORs_of_Subarrays {
    public int subarrayBitwiseORs(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0, st = 0, en = 0; i < arr.length; ++i, st = en, en = list.size()) {
            list.add(arr[i]);
            for (int j = st; j < en; ++j) {
                if (list.get(list.size() - 1) != (list.get(j) | arr[i])) {
                    list.add(list.get(j) | arr[i]);
                }
            }
        }
        return new HashSet<>(list).size();
    }
}
