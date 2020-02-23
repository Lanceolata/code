#!/usr/bin/python
# coding: utf-8

from TreeNode import *

class Solution(object):
    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        hLeft, hRight = self.leftHeight(root), self.rightHeight(root)
        if hLeft == hRight:
            return 2 ** hLeft - 1
        return self.countNodes(root.left) + self.countNodes(root.right) + 1

    def leftHeight(self, root):
        if not root:
            return 0
        return 1 + self.leftHeight(root.left)

    def rightHeight(self, root):
        if not root:
            return 0
        return 1 + self.rightHeight(root.right)