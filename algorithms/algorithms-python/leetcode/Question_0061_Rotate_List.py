#!/usr/bin/python
# coding: utf-8

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if not head or k < 0:
            return None
        if k == 0:
            return head
        n, cur = 1, head
        while cur.next:
            n += 1
            cur = cur.next
        cur.next = head
        n -= k % n
        while n > 0:
            n -= 1
            cur = cur.next
        head = cur.next
        cur.next = None
        return head
