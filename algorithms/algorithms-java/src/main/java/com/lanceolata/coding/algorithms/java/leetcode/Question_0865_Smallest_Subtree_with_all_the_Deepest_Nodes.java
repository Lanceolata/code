package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0865_Smallest_Subtree_with_all_the_Deepest_Nodes {
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

    private static class Pair<A, B> {
        public final A key;
        public final B value;

        public Pair(A key, B value) {
            this.key = key;
            this.value = value;
        }

        public static <A, B> Pair<A, B> of(A a, B b) {
            return new Pair<A, B>(a, b);
        }

        public A getKey() {
            return key;
        }

        public B getValue() {
            return value;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return deep(root).getValue();
    }

    private Pair<Integer, TreeNode> deep(TreeNode root) {
        if (root == null) {
            return Pair.of(0, null);
        }
        Pair<Integer, TreeNode> l = deep(root.left), r = deep(root.right);
        int d1 = l.getKey(), d2 = r.getKey();
        return Pair.of(Math.max(d1, d2) + 1, d1 == d2 ? root : d1 > d2 ? l.getValue() : r.getValue());
    }
}
