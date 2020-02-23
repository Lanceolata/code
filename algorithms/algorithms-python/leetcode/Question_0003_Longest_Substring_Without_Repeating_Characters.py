#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        index = [-1] * 128
        res, l = 0, -1
        for i, v in enumerate(s):
            c = ord(v)
            l = max(l, index[c])
            res = max(res, i - l)
            index[c] = i
        return res
