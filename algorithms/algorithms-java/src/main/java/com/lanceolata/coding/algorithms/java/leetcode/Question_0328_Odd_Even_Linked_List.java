package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0328_Odd_Even_Linked_List {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
        ListNode p1 = dummy1, p2 = dummy2;
        int cnt = 0;
        while (head != null) {
            if ((cnt & 1) == 0) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            cnt++;
            head = head.next;   
        }
        p2.next = null;
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
