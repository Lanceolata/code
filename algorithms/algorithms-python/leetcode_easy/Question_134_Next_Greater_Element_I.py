#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def nextGreaterElement(self, findNums, nums):
        """
        :type findNums: List[int]
        :type nums: List[int]
        :rtype: List[int]
        """
        m = {}
        s = []
        for num in nums:
            while s and s[-1] < num:
                m[s.pop()] = num
            s.append(num)
        res = []
        for num in findNums:
            res.append(m.get(num, -1))
        return res
