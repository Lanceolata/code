#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def repeatedSubstringPattern(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if not str:
            return False
        ss = (str + str)[1:-1]
        return ss.find(str) != -1
