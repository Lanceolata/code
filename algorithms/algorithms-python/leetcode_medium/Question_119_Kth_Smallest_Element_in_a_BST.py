#!/usr/bin/python
# coding: utf-8

from TreeNode import *

class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        cnt = self.count(root.left)
        if k <= cnt:
            return self.kthSmallest(root.left, k)
        elif k > cnt + 1:
            return self.kthSmallest(root.right, k - cnt - 1)
        return root.val


    def count(self, root):
        if not root:
            return 0
        return 1 + self.count(root.left) + self.count(root.right)