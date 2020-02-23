package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0099_Recover_Binary_Search_Tree {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode pre = null, first = null, second = null;

    public void recoverTree(TreeNode root) {
        // In order traversal to find the two elements
        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pre != null && first == null && pre.val >= root.val) {
            first = pre;
        }
        if (first != null && pre.val >= root.val) {
            second = root;
        }
        pre = root;
        inorder(root.right);
    }
}
