package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0572_Subtree_of_Another_Tree {
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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return root == subRoot;
        }
        return help(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean help(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return root == subRoot;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        return help(root.left, subRoot.left) && help(root.right, subRoot.right);
    }
}
