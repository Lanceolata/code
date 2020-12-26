package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0116_Populating_Next_Right_Pointers_in_Each_Node {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node cur = root, p = null;
        while (cur.left != null) {
            p = cur;
            while (p != null) {
                p.left.next = p.right;
                if (p.next != null) {
                    p.right.next = p.next.left;
                }
                p = p.next;
            }
            cur = cur.left;
        }
        return root;
    }
}
