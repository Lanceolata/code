package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0725_Split_Linked_List_in_Parts {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        int cnt = 0;
        ListNode p = head;
        while (p != null) {
            cnt++;
            p = p.next;
        }
        int width = cnt / k, rem = cnt % k;
        ListNode[] res = new ListNode[k];
        for (int i = 0; i < k; i++) {
            p = head;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; j++) {
                if (p != null) {
                    p = p.next;
                }
            }
            res[i] = head;
            if (p != null) {
                head = p.next;
                p.next = null;
            }
        }
        return res;
    }
}
