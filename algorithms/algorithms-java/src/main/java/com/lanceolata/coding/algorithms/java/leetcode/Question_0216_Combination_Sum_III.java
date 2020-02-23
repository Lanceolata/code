package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0216_Combination_Sum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        help(k, n, 1, list, res);
        return res;
    }

    private void help(int k, int n, int i, List<Integer> list, List<List<Integer>> res) {
        if (n < 0) {
            return;
        }
        if (n == 0 && list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j <= 9; j++) {
            list.add(j);
            help(k, n - j, j + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
