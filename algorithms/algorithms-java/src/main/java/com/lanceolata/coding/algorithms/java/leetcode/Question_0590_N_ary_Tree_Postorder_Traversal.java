package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Question_0590_N_ary_Tree_Postorder_Traversal {
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
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        help(root, res);
        return res;
    }

    private void help(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node p : root.children) {
            help(p, res);
        }
        res.add(root.val);
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            root = stack.pop();
            res.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                stack.push(root.children.get(i));
            }
        }
        Collections.reverse(res);
        return res;
    }
}
