#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def findMaxAverage(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """
        num = 0
        for i in range(k):
            num += nums[i]
        
        res = num
        for i in range(k, len(nums)):
            num += nums[i] - nums[i - k]
            if num > res:
                res = num
        return float(res) / k