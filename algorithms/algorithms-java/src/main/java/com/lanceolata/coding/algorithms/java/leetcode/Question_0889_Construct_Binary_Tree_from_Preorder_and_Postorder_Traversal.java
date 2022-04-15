package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal {
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

    private int preIndex = 0, posIndex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (root.val != postorder[posIndex]) {
            root.left = constructFromPrePost(preorder, postorder);
        }
        if (root.val != postorder[posIndex]) {
            root.right = constructFromPrePost(preorder, postorder);
        }
        posIndex++;
        return root;
    }
}
