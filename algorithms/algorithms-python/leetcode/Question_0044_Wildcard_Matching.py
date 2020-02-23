#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        i, j, m, n, match, index = 0, 0, len(s), len(p), 0, -1
        while i < m:
            if j < n and (p[j] == '?' or s[i] == p[j]):
                i, j = i + 1, j + 1
            elif j < n and p[j] == '*':
                match = i
                index = j
                j += 1
            elif index != -1:
                j = index + 1
                match += 1
                i = match
            else:
                return False

        while j < n and p[j] == '*':
            j += 1
        return j == n
