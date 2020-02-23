#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        if nums[0] <= nums[-1]:
            return nums[0]
        l, r = 0, len(nums) - 1
        while l < r - 1:
            mid = l + (r - l) / 2
            if nums[l] < nums[mid]:
                l = mid
            else:
                r = mid
        return min(nums[l], nums[r])