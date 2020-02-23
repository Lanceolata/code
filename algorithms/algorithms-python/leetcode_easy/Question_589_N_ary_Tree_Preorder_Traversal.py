#!/usr/bin/python
# coding: utf-8

# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children


class Solution(object):
    def preorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        res = []
        def help(node):
            if node:
                res.append(node.val)
                for i in node.children:
                    help(i)
        help(root)
        return res