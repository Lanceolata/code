#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def fairCandySwap(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        diff = (sum(A) - sum(B)) / 2
        s = set(A)
        for i in B:
            if (diff + i) in s:
                return [diff + i, i]
        return []