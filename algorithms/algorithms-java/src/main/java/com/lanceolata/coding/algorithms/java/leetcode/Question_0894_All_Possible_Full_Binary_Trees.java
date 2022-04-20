package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Question_0894_All_Possible_Full_Binary_Trees {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> allPossibleFBT(int n) {
        Map<Integer, List<TreeNode>> res = new HashMap<>();
        return help(n, res);
    }

    private List<TreeNode> help(int n, Map<Integer, List<TreeNode>> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        List<TreeNode> res = new LinkedList<>();
        if (n == 1) {
            res.add(new TreeNode(0));
        } else if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                int j = n - 1 - i;
                for (TreeNode left: help(i, map)) {
                    for (TreeNode right : help(j, map)) {
                        res.add(new TreeNode(0, left, right));
                    }
                }
            }
        }
        map.put(n, res);
        return res;
    }
}
