#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False
        table = [0] * 26
        a = ord('a')
        for c in s:
            table[ord(c) - a] += 1
        for c in t:
            table[ord(c) - a] -= 1
            if table[ord(c) - a] < 0:
                return False
        return True
