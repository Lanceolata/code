#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        res = nums[0] + nums[1] + nums[2]
        diff = abs(res - target)
        nums.sort()
        for n in range(len(nums)):
            l, r = n + 1, len(nums) - 1
            while l < r:
                num = nums[n] + nums[l] + nums[r]
                ndiff = abs(num - target)
                if ndiff < diff:
                    diff = ndiff
                    res = num
                if num < target:
                    l += 1
                else:
                    r -= 1
        return res
