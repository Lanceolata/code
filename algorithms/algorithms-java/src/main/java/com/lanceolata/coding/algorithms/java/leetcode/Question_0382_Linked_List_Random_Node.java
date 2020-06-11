package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Random;

public class Question_0382_Linked_List_Random_Node {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private ListNode head;
    private Random random;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Question_0382_Linked_List_Random_Node(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int res = head.val, i = 2;
        ListNode cur = head.next;
        while (cur != null) {
            int j = random.nextInt() % i;
            if (j == 0) {
                res = cur.val;
            }
            ++i;
            cur = cur.next;
        }
        return res;
    }
}
