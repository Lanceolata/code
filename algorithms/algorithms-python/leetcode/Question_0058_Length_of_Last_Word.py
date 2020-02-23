#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        num, last = 0, len(s) - 1
        while last >= 0 and s[last] == " ":
            last -= 1
        while last >= 0 and s[last] != " ":
            last -= 1
            num += 1
        return num
