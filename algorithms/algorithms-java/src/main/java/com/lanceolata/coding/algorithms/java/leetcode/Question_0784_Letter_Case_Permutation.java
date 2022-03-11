package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0784_Letter_Case_Permutation {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        help(s.toCharArray(), 0, res);
        return res;
    }

    private void help(char[] arr, int i, List<String> res) {
        if (i >= arr.length) {
            res.add(new String(arr));
            return;
        }
        help(arr, i + 1, res);
        char c = arr[i];
        if (c >= 'a' && c <= 'z') {
            arr[i] -= 32;
            help(arr, i + 1, res);
        } else if (c >= 'A' && c <= 'Z') {
            arr[i] += 32;
            help(arr, i + 1, res);
        }
        arr[i] = c;
    }
}
