package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0897_Increasing_Order_Search_Tree {
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

    private TreeNode cur;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = new TreeNode(0);
        cur = res;
        inorder(root);
        return res.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }
}
