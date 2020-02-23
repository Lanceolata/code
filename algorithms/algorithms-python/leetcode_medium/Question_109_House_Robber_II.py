#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        return max(self.robHouse(nums, 0, len(nums) - 2), self.robHouse(nums, 1, len(nums) - 1))

    def robHouse(self, nums, start, end):
        prerob, prenotrob = 0, 0
        for i in range(start, end + 1):
            temp = prerob
            prerob = prenotrob + nums[i]
            prenotrob = max(temp, prenotrob)
        return max(prerob, prenotrob)