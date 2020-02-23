#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def findErrorNums(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        dup = -1
        missing = -1
        for num in nums:
            n = abs(num) - 1
            if nums[n] < 0:
                dup = abs(num)
            else:
                nums[n] *= -1
        for i in range(len(nums)):
            if nums[i] > 0:
                missing = i + 1

        return [dup, missing]
