#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        if len(s1) + len(s2) != len(s3):
            return False
        s = set()
        return self.help(s1, 0, s2, 0, s3, 0, s)

    def help(self, s1, i, s2, j, s3, k, s):
        key = len(s3) * i + j
        if key in s:
            return False
        if i == len(s1):
            return s2[j:] == s3[k:]
        if j == len(s2):
            return s2[i:] == s3[k:]
        if s1[i] == s3[k] and self.help(s1, i + 1, s2, j, s3, k + 1, s):
            return True
        if s2[j] == s3[k] and self.help(s1, i, s2, j + 1, s3, k + 1, s):
            return True
        s.add(key)
        return False
