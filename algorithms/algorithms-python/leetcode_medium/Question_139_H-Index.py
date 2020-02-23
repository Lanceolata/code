#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        cs = sorted(citations)
        cs.reverse()
        length = len(cs)
        for i in range(length):
            if i >= cs[i]:
                return i
        return length