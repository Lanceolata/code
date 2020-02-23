#!/usr/bin/python
# coding: utf-8

# Definition for a Node.
class Node(object):
    def __init__(self, val, next, random):
        self.val = val
        self.next = next
        self.random = random


class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        if not head:
            return None
        p = head
        while p:
            node = Node(p.val, None, None)
            node.next = p.next
            p.next = node
            p = node.next

        p = head
        while p:
            if p.random:
                p.next.random = p.random.next
            p = p.next.next

        p, newHead = head, head.next
        while p:
            next = p.next
            p.next = next.next
            if next.next:
                next.next = next.next.next
            p = p.next
        return newHead
