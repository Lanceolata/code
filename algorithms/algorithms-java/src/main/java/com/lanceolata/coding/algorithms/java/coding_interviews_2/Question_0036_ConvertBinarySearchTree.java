package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0036_ConvertBinarySearchTree {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode last;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        last = null;
        help(pRootOfTree);
        while (pRootOfTree.left != null) {
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.left);
        root.left = last;
        if (last != null) {
            last.right = root;
        }
        last = root;
        if (root.right != null) {
            help(root.right);
        }
    }
}
