#!/usr/bin/python
# coding: utf-8

from TreeNode import *

class Solution(object):
    def isSubtree(self, s, t):
        """
        :type s: TreeNode
        :type t: TreeNode
        :rtype: bool
        """
        return self.help(s, t)

    def help(self, s, t):
        return s != None and (self.equal(s, t) or self.help(s.left, t) or self.help(s.right, t))

    def equal(self, s, t):
        if not s and not t:
            return True
        if not s or not t:
            return False
        return s.val == t.val and self.equal(s.left, t.left) and self.equal(s.right, t.right)