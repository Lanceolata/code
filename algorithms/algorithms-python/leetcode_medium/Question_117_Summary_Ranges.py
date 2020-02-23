#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        res = []
        i, n = 0, len(nums)
        while i < n:
            j = 1
            while i + j < n and nums[i + j] - nums[i] == j:
                j += 1
            if j == 1:
                res.append(str(nums[i]))
            else:
                res.append("%d->%d" % (nums[i], nums[i + j - 1]))
            i += j
        return res