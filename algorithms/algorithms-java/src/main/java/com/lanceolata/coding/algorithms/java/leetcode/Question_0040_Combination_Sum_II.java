package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_0040_Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        help(candidates, target, 0, list, res);
        return res;
    }

    private void help(int[] candidates, int target, int i, List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            if (candidates[j] > target) {
                break;
            }
            // 注意 去重
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }
            list.add(candidates[j]);
            help(candidates, target - candidates[j], j + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
