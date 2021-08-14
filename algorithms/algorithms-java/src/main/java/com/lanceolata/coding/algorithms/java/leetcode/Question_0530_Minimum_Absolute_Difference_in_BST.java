package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0530_Minimum_Absolute_Difference_in_BST {
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

    private int res;
    private Integer pre;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return -1;
        }
        res = Integer.MAX_VALUE;
        Integer pre = null;
        help(root);
        return res;
    }

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.left);
        if (pre != null) {
            res = Math.min(res, root.val - pre);
        }
        pre = root.val;
        help(root.right);
    }
}
