package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0606_Construct_String_from_Binary_Tree {
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

    public String tree2str(TreeNode root) {
        StringBuilder res = new StringBuilder();
        help(root, res);
        return res.toString();
    }

    private void help(TreeNode root, StringBuilder res) {
        if (root == null) {
            return;
        }
        res.append(root.val);
        if (root.right != null) {
            res.append('(');
            help(root.left, res);
            res.append(")(");
            help(root.right, res);
            res.append(")");
        } else if (root.left != null) {
            res.append('(');
            help(root.left, res);
            res.append(")");
        }
    }
}
