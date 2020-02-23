package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0077_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        help(n, k, 1, list, res);
        return res;
    }

    private void help(int n, int k, int i, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (; i <= n; i++) {
            list.add(i);
            help(n, k, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
