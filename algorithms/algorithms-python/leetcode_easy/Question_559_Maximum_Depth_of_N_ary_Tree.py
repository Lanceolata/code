#!/usr/bin/python
# coding: utf-8

class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children


class Solution(object):
    def maxDepth(self, root):
        """
        :type root: Node
        :rtype: int
        """
        if not root:
            return 0
        dep = 0
        for i in root.children:
            dep = max(dep, self.maxDepth(i))
        return dep + 1