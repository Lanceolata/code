#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        res = [0, 0]
        for i in range(len(s)):
            self.help(s, i, i, res)
            self.help(s, i, i + 1, res)
        return s[res[0]:res[0] + res[1]]


    def help(self, s, l, r, res):
        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1
            r += 1
        if r - l - 1 > res[1]:
            res[1] = r - l - 1
            res[0] = l + 1
