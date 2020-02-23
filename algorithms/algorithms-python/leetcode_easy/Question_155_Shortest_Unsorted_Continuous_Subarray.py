#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def findUnsortedSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        start = -1
        end = -2
        maxNum = nums[0]
        minNum = nums[-1]
        n = len(nums)
        for i in range(1, n):
            maxNum = max(maxNum, nums[i])
            minNum = min(minNum, nums[n - i - 1])
            if maxNum != nums[i]:
                end = i
            if minNum != nums[n - i - 1]:
                start = n - i - 1
        return end - start + 1