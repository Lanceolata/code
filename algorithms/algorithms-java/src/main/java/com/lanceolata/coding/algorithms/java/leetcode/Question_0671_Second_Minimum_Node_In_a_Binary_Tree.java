package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0671_Second_Minimum_Node_In_a_Binary_Tree {
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

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = (root.left != null && root.left.val != root.val) ? root.left.val : findSecondMinimumValue(root.left);
        int right = (root.right != null && root.right.val != root.val) ? root.right.val : findSecondMinimumValue(root.right);
        if (left == -1 || right == -1) {
            return Math.max(left, right);
        }
        return Math.min(left, right);
    }
}
