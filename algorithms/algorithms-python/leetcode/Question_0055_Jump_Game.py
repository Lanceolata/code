#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if not nums:
            return False
        if len(nums) == 1:
            return True
        
        m = 0
        n = len(nums) - 1
        for i in range(n):
            m = max(m, i + nums[i])
            if m < i + 1:
                return False
            if m >= n:
                return True
        return False
