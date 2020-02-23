#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def findTheDifference(self, s, t):
        return list((collections.Counter(t) - collections.Counter(s)))[0]

    def findTheDifference_fast(self, s, t):
        c = 0
        for i in s + t:
            c ^= ord(i)
        return chr(c)
