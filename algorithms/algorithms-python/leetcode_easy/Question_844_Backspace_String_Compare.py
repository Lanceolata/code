#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def backspaceCompare(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: bool
        """
        s = self.help(S)
        t = self.help(T)
        return s == t


    def help(self, s):
        stack = []
        for c in s:
            if c == "#":
                if stack:
                    stack.pop()
            else:
                stack.append(c)
        return stack