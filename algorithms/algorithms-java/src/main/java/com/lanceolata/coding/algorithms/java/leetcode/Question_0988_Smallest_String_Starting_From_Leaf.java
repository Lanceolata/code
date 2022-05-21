package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0988_Smallest_String_Starting_From_Leaf {
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

    private String res;

    public String smallestFromLeaf(TreeNode root) {
        res = null;
        dfs(root, new StringBuilder());
        return res;
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append((char) ('a' + node.val));
        if (node.left == null && node.right == null) {
            sb.reverse();
            String cur = sb.toString();
            sb.reverse();
            if (res == null || cur.compareTo(res) < 0) {
                res = cur;
            }
        }
        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
