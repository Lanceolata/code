package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.List;

public class Question_0559_Maximum_Depth_of_N_ary_Tree {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int sub = 0;
        for (Node n : root.children) {
            sub = Math.max(sub, maxDepth(n));
        }
        return sub + 1;
    }
}
