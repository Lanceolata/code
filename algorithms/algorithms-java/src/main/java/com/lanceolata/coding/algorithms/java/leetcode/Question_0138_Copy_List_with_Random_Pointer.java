package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0138_Copy_List_with_Random_Pointer {
    // Definition for a Node.
    public class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node p = head;
        while (p != null) {
            Node copy = new Node(p.val, p.next, null);
            p.next = copy;
            p = p.next.next;
        }
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        Node copyHead = head.next, next = null;
        p = head;
        while (p != null) {
            next = p.next.next;
            if (next != null) {
                p.next.next = next.next;
            }
            p.next = next;
            p = next;
        }
        return copyHead;
    }
}
