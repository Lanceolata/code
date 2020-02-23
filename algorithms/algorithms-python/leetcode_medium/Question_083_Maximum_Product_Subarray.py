#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        pre_min, pre_max, res = nums[0], nums[0], nums[0]
        cur_min, cur_max = 0, 0
        for i in range(1, len(nums)):
            n = nums[i]
            cur_min = min(pre_min * n, pre_max * n, n)
            cur_max = max(pre_min * n, pre_max * n, n)
            pre_min = cur_min
            pre_max = cur_max
            res = max(pre_max, res)
        return res