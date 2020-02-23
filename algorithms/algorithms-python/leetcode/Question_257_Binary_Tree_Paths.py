#!/usr/bin/python
# coding: utf-8

from TreeNode import *

class Solution(object):
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        paths = []
        if root:
            self.searchBT(root, "", paths)
        return paths

    def searchBT(self, root, path, paths):
        if not root.left and not root.right:
            paths.append(path + str(root.val))
        if root.left:
            self.searchBT(root.left, path + str(root.val) + "->", paths)
        if root.right:
            self.searchBT(root.right, path + str(root.val) + "->", paths)

