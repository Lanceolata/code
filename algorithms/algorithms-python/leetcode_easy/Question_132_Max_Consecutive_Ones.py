#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res, count = 0, 0
        for num in nums:
            if num == 1:
                count += 1
            else:
                res = max(res, count)
                count = 0
        res = max(res, count)
        return res
