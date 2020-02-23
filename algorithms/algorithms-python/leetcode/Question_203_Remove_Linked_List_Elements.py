#!/usr/bin/python
# coding: utf-8

from ListNode import *

class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        if not head:
            return None
        head.next = self.removeElements(head.next, val)
        return head.next if head.val == val else head
