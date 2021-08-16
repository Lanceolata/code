package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0543_Diameter_of_Binary_Tree {
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
    private int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        help(root);
        return res;
    }

    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = help(root.left);
        int right = help(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}
