#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        return " ".join([w[::-1] for w in s.strip().split()])


