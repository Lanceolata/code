#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        a, b = 0, 0
        for i in nums:
            b = (b ^ i) & ~a
            a = (a ^ i) & ~b
        return b