#!/usr/bin/python
# coding: utf-8

import sys

class Solution(object):
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        num, left, n, res = 0, 0, len(nums), sys.maxint
        for i in range(n):
            num += nums[i]
            while num >= s:
                res = min(res, i + 1 - left)
                num -= nums[left]
                left += 1
        return 0 if res == sys.maxint else res