#!/usr/bin/python
# coding: utf-8

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        return self.help(inorder, 0, len(inorder) - 1, postorder, 0, len(postorder) - 1)

    def help(self, inorder, inStart, inEnd, postorder, postStart, postEnd):
        if postStart > postEnd or inStart > inEnd:
            return None
        value = postorder[postEnd]
        index = inorder.index(value, inStart, inEnd + 1)
        length = index - inStart
        root = TreeNode(value)
        root.left = self.help(inorder, inStart, index - 1, postorder, postStart, postStart + length - 1)
        root.right = self.help(inorder, index + 1, inEnd, postorder, postStart + length, postEnd - 1)
        return root
