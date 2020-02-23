#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        res = []
        self.help("", 0, 0, n, res)
        return res


    def help(self, pre, o, c, n, res):
        if len(pre) == 2 * n:
            res.append(pre)
            return
        if o < n:
            self.help(pre + "(", o + 1, c, n, res)
        if c < o:
            self.help(pre + ")", o, c + 1, n, res)
