#!/usr/bin/python
# coding: utf-8

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        fp, sp = head, head
        while fp and fp.next:
            sp = sp.next
            fp = fp.next.next
            if sp == fp:
                break
        if not fp or not fp.next:
            return None
        sp = head
        while sp != fp:
            sp = sp.next
            fp = fp.next
        return sp
