package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0445_Add_Two_Numbers_II {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            carry += l1 == null ? 0 : l1.val;
            carry += l2 == null ? 0 : l2.val;
            p.next = new ListNode(carry % 10);
            carry /= 10;
            p = p.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
