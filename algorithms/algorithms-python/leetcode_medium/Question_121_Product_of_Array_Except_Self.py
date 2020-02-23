#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        l, p = len(nums), 1
        vec = [1] * l
        for i in range(1, l):
            p *= nums[i - 1]
            vec[i] = p
        p = 1
        for i in range(l - 2, -1, -1):
            p *= nums[i + 1]
            vec[i] *= p
        return vec
