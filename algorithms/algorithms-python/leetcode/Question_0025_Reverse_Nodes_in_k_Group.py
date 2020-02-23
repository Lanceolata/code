#!/usr/bin/python
# coding: utf-8

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        dummy = ListNode(0)
        dummy.next = head
        pre, next, last, i = dummy, None, None, 0
        while head:
            i += 1
            next = head.next
            if i % k == 0:
                head.next = None
                last = pre.next
                pre.next = self.reverse(pre.next)
                last.next = next
                pre = last
            head = next
        return dummy.next


    def reverse(self, head):
        pre, next = None, None
        while head:
            next = head.next
            head.next = pre
            pre = head
            head = next
        return pre
