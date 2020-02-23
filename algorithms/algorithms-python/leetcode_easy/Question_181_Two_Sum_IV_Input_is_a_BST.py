#!/usr/bin/python
# coding: utf-8

from TreeNode import *

class Solution(object):
    def findTarget(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: bool
        """
        vec = []
        self.inorder(root, vec)
        low = 0
        high = len(vec) - 1
        while low < high:
            count = vec[low] + vec[high]
            if count == k:
                return True
            elif count < k:
                low += 1
            else:
                high -= 1
        return False

    def inorder(self, root, vec):
        if not root:
            return
        self.inorder(root.left, vec)
        vec.append(root.val)
        self.inorder(root.right, vec)
