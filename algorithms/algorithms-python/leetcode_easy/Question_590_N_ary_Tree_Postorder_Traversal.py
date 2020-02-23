#!/usr/bin/python
# coding: utf-8

class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children

class Solution(object):
    def postorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        res = []
        def help(node):
            if not node:
                 return
            for n in node.children:
                help(n)
            res.append(node.val)
        help(root)
        return res