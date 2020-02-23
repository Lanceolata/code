#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def rotatedDigits(self, N):
        """
        :type N: int
        :rtype: int
        """
        s1 = set([1, 8, 0])
        s2 = set([1, 2, 5, 8, 6, 9, 0])
        def isGood(n):
            s = set([int(i) for i in str(n)])
            return s.issubset(s2) and not s.issubset(s1)
        return sum(isGood(i) for i in range(N + 1))