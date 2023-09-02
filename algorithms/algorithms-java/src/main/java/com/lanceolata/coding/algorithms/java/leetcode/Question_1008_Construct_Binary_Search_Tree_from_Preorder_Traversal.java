package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1008_Construct_Binary_Search_Tree_from_Preorder_Traversal {
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

    private int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return help(preorder, Integer.MAX_VALUE);
    }

    public TreeNode help(int[] preorder, int bound) {
        if (i == preorder.length || preorder[i] > bound) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = help(preorder, root.val);
        root.right = help(preorder, bound);
        return root;
    }
}
