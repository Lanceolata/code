#!/usr/bin/python
# coding: utf-8

from TreeNode import *

class Solution(object):
    def findTilt(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        tilt = [0]
        self.help(root, tilt)
        return tilt[0]

    def help(self, root, tilt):
        if not root:
            return 0

        left = self.help(root.left, tilt)
        right = self.help(root.right, tilt)
        tilt[0] += abs(left - right)
        return left +right +root.val
