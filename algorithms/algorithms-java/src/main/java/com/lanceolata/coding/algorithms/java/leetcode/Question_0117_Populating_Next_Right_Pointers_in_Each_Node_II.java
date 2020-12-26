package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0117_Populating_Next_Right_Pointers_in_Each_Node_II {
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
        Node cur = root, dummy = new Node(0, null, null, null), p = null;
        p = dummy;
        while (cur != null) {
            if (cur.left != null) {
                p.next = cur.left;
                p = p.next;
            }
            if (cur.right != null) {
                p.next = cur.right;
                p = p.next;
            }
            cur = cur.next;
            if (cur == null) {
                cur = dummy.next;
                dummy.next = null;
                p = dummy;
            }
        }
        return root;
    }
}
