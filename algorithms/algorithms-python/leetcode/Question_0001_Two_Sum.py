#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        m = {}
        for i, v in enumerate(nums):
            diff = target - v
            if diff in m:
                return [m[diff], i]
            m[v] = i
        return None
