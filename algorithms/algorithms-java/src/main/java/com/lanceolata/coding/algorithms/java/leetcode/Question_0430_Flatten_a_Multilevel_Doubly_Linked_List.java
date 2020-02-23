package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0430_Flatten_a_Multilevel_Doubly_Linked_List {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        Node p = head;
        while (p != null) {
            if (p.child == null) {
                p = p.next;
                continue;
            }
            Node t = p.child;
            while (t.next != null) {
                t = t.next;
            }
            t.next = p.next;
            if (p.next != null) {
                p.next.prev = t;
            }
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
}
