package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0965_Univalued_Binary_Tree {
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

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return help(root, root.val);
    }

    private boolean help(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        return root.val == val && help(root.left, val) && help(root.right, val);
    }
}
