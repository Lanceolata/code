#!/usr/bin/python
# coding: utf-8

import sys

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0

        res = -sys.maxint - 1
        cur = 0
        for i in nums:
            cur += i
            if cur > res:
                res = cur
            if cur < 0:
                cur = 0
        return res
