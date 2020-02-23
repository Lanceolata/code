package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0025_Reverse_Nodes_in_k_Group {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        int cnt = 0;
        while (head != null) {
            cnt++;
            if (cnt % k == 0) {
                p = reverseGroup(p, head.next);
                head = p;
            }
            head = head.next;
        }
        return dummy.next;
    }

    private ListNode reverseGroup(ListNode pre, ListNode end) {
        ListNode last = pre.next, cur = pre.next.next;
        while (cur != end) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }
}
