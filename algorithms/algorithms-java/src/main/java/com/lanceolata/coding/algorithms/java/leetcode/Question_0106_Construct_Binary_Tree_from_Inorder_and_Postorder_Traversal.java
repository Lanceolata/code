package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return help(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode help(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        int i = inStart;
        for (; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                break;
            }
        }
        int len = i - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = help(inorder, inStart, i - 1, postorder, postStart, postStart + len - 1);
        root.right = help(inorder, i + 1, inEnd, postorder, postStart + len, postEnd - 1);
        return root;
    }
}
