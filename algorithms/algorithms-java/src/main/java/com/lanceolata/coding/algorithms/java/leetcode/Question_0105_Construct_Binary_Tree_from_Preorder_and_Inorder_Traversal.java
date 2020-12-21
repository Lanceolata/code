package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode help(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int i = inStart;
        for (; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                break;
            }
        }
        int len = i - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = help(preorder, preStart + 1, preStart + len, inorder, inStart, i - 1);
        root.right = help(preorder, preStart + len + 1, preEnd, inorder, i + 1, inEnd);
        return root;
    }
}
