package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1080_Insufficient_Nodes_in_Root_to_Leaf_Paths {
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

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return help(root, limit, 0) ? root : null;
    }

    private boolean help(TreeNode root, int limit, int pre) {
        if (root == null) {
            return false;
        }
        pre += root.val;
        if (root.left == null && root.right == null) {
            return pre >= limit;
        }
        boolean left = help(root.left, limit, pre);
        boolean right = help(root.right, limit, pre);
        if (!left) {
            root.left = null;
        }
        if (!right) {
            root.right = null;
        }
        if (!left && !right) {
            return false;
        }
        return true;
    }
}
