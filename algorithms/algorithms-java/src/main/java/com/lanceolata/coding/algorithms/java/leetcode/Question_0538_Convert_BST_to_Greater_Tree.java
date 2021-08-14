package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0538_Convert_BST_to_Greater_Tree {
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

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        sum = 0;
        help(root);
        return root;
    }

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.right);
        sum += root.val;
        root.val = sum;
        help(root.left);
    }
}
