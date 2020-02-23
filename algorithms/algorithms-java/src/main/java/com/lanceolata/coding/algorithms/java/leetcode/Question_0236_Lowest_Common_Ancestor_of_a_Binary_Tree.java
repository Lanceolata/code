package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0236_Lowest_Common_Ancestor_of_a_Binary_Tree {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if (left != null && left != p && left != q) {
            return left;
        }
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (right != null && right != p && right != q) {
            return right;
        }
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
