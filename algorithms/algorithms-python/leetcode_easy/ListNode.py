#!/usr/bin/python
# coding: utf-8

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

    @staticmethod
    def printNode(node):
        while node:
            print node.val
            node = node.next


