#!/usr/bin/python
# coding: utf-8

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """
        if not head:
            return head
        dummy = ListNode(0)
        dummy.next = head
        pre = dummy
        for i in range(1, m):
            pre = pre.next
        last, cur = pre.next, None
        for i in range(m, n):
            cur = last.next
            last.next = cur.next
            cur.next = pre.next
            pre.next = cur
        return dummy.next
