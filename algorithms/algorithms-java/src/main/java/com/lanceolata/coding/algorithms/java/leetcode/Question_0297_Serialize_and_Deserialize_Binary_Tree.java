package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0297_Serialize_and_Deserialize_Binary_Tree {
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

    private static final String spliter = ",";
    private static final String NN = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }
    }

    private int index = -1;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        index = -1;
        String[] strs = data.split(spliter);
        return buildTree(strs);
    }

    private TreeNode buildTree(String[] strs) {
        index++;
        if (!strs[index].equals("#")) {
            TreeNode root = new TreeNode(0);
            root.val = Integer.parseInt(strs[index]);
            root.left = buildTree(strs);
            root.right = buildTree(strs);
            return root;
        }
        return null;
    }
}
