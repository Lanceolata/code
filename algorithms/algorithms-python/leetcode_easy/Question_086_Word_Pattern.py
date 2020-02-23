#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        s = pattern
        t = str.split()
        return len(s) == len(t) and len(set(zip(s, t))) == len(set(s)) === len(set(t))
