#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def isValidSerialization(self, preorder):
        """
        :type preorder: str
        :rtype: bool
        """
        cap, preorder = 1, preorder + ","
        for i in range(len(preorder)):
            if preorder[i] != ",":
                continue
            cap -= 1
            if cap < 0:
                return False
            if preorder[i - 1] != "#":
                cap += 2
        return cap == 0