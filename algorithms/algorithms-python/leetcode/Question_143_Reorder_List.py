#!/usr/bin/python
# coding: utf-8

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        fast = self.reverse(slow.next)
        slow.next = None
        self.merge(head, fast)


    def reverse(self, head):
        pre, next = None, None
        while head:
            next = head.next
            head.next = pre
            pre = head
            head = next
        return pre


    def merge(self, head1, head2):
        next = None
        while head1 and head2:
            next = head1.next
            head1.next = head2
            head1 = next
            next = head2.next
            head2.next = head1
            head2 = next
