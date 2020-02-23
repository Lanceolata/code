#!/usr/bin/python
# coding: utf-8

from TreeNode import *

class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack = []
        while root:
            self.stack.append(root)
            root = root.left
        

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.stack) > 0
        

    def next(self):
        """
        :rtype: int
        """
        node = self.stack.pop()
        res = node.val;
        if node.right:
            node = node.right
            while node:
                self.stack.append(node)
                node = node.left
        return res;