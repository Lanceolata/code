package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_1078_Occurrences_After_Bigram {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String[] arr = text.split(" ");
        for (int i = 2; i < arr.length; i++) {
            if (first.equals(arr[i - 2]) && second.equals(arr[i - 1])) {
                list.add(arr[i]);
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
