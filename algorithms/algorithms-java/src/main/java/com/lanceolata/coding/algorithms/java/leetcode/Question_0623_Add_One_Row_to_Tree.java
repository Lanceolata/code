package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0623_Add_One_Row_to_Tree {
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

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode nRoot = new TreeNode(val, root, null);
            return nRoot;
        }
        help(root, val, depth);
        return root;
    }

    private void help(TreeNode root, int val, int depth) {
        if (root == null) {
            return;
        }
        depth--;
        if (depth == 1) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        } else {
            help(root.left, val, depth);
            help(root.right, val, depth);
        }
    }
}
