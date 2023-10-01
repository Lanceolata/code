package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Stack;

public class Question_1028_Recover_a_Tree_From_Preorder_Traversal {
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

    public TreeNode recoverFromPreorder(String traversal) {
        int level, val;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < traversal.length(); ) {
            for (level = 0; traversal.charAt(i) == '-'; i++) {
                level++;
            }
            for (val = 0; i < traversal.length() && traversal.charAt(i) != '-'; i++) {
                val = val * 10 + (traversal.charAt(i) - '0');
            }
            while (stack.size() > level) {
                stack.pop();
            }
            TreeNode node = new TreeNode(val);
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            stack.add(node);
        }
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.pop();
    }
}
