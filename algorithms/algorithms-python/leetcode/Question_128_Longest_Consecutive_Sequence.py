#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        if len(nums) <= 1:
            return len(nums)
        res = 1
        s = set(nums)
        for n in nums:
            if (n - 1) not in s:
                l = 1
                while (n + 1) in s:
                    n += 1
                    l += 1
                res = max(res, l)
        return res
