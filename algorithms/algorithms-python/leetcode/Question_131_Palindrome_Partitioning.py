#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        res, vec = [], []
        if not s:
            return res
        self.helper(s, vec, res, 0)
        return res

    def helper(self, s, vec, res, pos):
        if len(s) <= pos:
            res.append(vec[:])
            return

        for i in range(pos, len(s)):
            if self.isPalindrome(s, pos, i):
                vec.append(s[pos:i+1])
                self.helper(s, vec, res, i + 1)
                vec.pop()

    def isPalindrome(self, s, start, end):
        while start < end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
        return True
