#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def findLHS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        m = {}
        for i in nums:
            m[i] = m.get(i, 0) + 1
        res = 0
        for k, v in m.items():
            if k + 1 in m:
                res = max(res, v + m[k + 1])
        return res
