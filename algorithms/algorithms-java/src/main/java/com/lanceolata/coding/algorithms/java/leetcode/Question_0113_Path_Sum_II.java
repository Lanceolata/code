package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0113_Path_Sum_II {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        help(root, sum, list, res);
        return res;
    }

    private void help(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<>(list));
        } else {
            help(root.left, sum - root.val, list, res);
            help(root.right, sum - root.val, list, res);
        }
        list.remove(list.size() - 1);
    }
}
