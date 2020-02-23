#!/usr/bin/python
# coding: utf-8

from TreeNode import *

class Solution(object):
    def convertBST(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        sum = [0]
        self.convertBSTHelp(root, sum)
        return root

    def convertBSTHelp(self, root, sum):
        if not root:
            return

        self.convertBSTHelp(root.right, sum)
        sum[0] += root.val
        root.val = sum[0]
        self.convertBSTHelp(root.left, sum)

