package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1022_Sum_of_Root_To_Leaf_Binary_Numbers {
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

    public int sumRootToLeaf(TreeNode root) {
        res = 0;
        help(root, 0);
        return res;
    }

    private void help(TreeNode root, int pre) {
        if (root == null) {
            return;
        }
        pre = (pre << 1) | root.val;
        if (root.left != null || root.right != null) {
            help(root.left, pre);
            help(root.right, pre);
        } else {
            res += pre;
        }
    }
}
