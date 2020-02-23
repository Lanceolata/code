#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def findMode(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        t = [None, 1, 0]
        self.inorder(root, t, res)
        return res

    def inorder(self, node, t, res):
        if not node:
            return
        self.inorder(node.left, t, res)
        if t[0]:
            if node.val == t[0].val:
                t[1] += 1
            else:
                t[1] = 1
        if t[1] >= t[2]:
            if t[1] > t[2]:
                del res[:]
            res.append(node.val)
            t[2] = t[1]
        t[0] = node
        self.inorder(node.right, t, res)