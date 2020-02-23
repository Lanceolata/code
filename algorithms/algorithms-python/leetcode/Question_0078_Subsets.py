#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = [[]]
        for num in nums :
            for temp in res[:] :
                x = temp[:]
                x.append(num)
                res.append(x)
        return res
