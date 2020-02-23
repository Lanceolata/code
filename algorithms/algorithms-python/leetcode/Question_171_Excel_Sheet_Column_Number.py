#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        return reduce(lambda x, y : x *26 + y, [ord(c) - ord('A') + 1 for c in s])
