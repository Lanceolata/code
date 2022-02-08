package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0655_Print_Binary_Tree {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        int m = getHeight(root);
        int n = (int) Math.pow(2, m) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add("");
            }
            res.add(list);
        }
        place(root, 0, 0, n - 1, res);
        return res;
    }

    private int getHeight(TreeNode root) {
        return root == null ? 0 : Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private void place(TreeNode root, int r, int s, int e, List<List<String>> res) {
        if (root == null) {
            return;
        }
        int m = s + (e - s) / 2;
        res.get(r).set(m, String.valueOf(root.val));
        place(root.left, r + 1, s, m - 1, res);
        place(root.right, r + 1, m + 1, e, res);
    }
}
