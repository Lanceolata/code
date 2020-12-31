package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0138_Copy_List_with_Random_Pointer {
    // Definition for a Node.
    public class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

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
