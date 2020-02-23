#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        index = 0
        for i, v in enumerate(nums):
            if v != 0:
                if index != i:
                    nums[index] = v
                index += 1
        for i in range(index, len(nums)):
            nums[i] = 0

            
