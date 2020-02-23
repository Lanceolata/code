#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def longestUnivaluePath(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        res = [0]
        self.help(root, res)
        return res[0]

    def help(self, root, res):
        if not root:
            return 0
        left = self.help(root.left, res)
        right = self.help(root.right, res)
        leftRes, rightRes = 0, 0
        if root.left and root.val == root.left.val:
            leftRes += left + 1
        if root.right and root.val == root.right.val:
            rightRes += right + 1
        res[0] = max(res[0], leftRes + rightRes)
        return max(leftRes,rightRes)