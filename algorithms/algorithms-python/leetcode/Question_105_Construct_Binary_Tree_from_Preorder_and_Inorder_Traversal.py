#!/usr/bin/python
# coding: utf-8

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        return self.help(preorder, 0, len(preorder) - 1, inorder, 0, len(inorder) - 1)

    def help(self, preorder, preStart, preEnd, inorder, inStart, inEnd):
        if preStart > preEnd or inStart > inEnd:
            return None
        value = preorder[preStart]
        index = inorder.index(value, inStart, inEnd + 1)
        length = index - inStart
        root = TreeNode(value)
        root.left = self.help(preorder, preStart + 1, preStart + length, inorder, inStart, index - 1)
        root.right = self.help(preorder, preStart + length + 1, preEnd, inorder, index + 1, inEnd)
        return root
