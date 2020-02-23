package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0429_N_ary_Tree_Level_Order_Traversal {

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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = q.size();
            while (len-- > 0) {
                Node n = q.poll();
                list.add(n.val);
                for (int i = 0; i < n.children.size(); i++) {
                    q.add(n.children.get(i));
                }
            }
            res.add(list);
        }
        return res;
    }
}
