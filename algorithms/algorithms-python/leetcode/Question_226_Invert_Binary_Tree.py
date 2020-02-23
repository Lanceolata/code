#!/usr/bin/python
# coding: utf-8

import Queue.Queue

class Solution(object):
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if not root:
            return None
        right = self.invertTree(root.right)
        left = self.invertTree(root.left)
        root.right, root.left = left, right
        return root
