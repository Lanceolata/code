#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        prerob, prenotrob = 0, 0
        for i in nums:
            prerob, prenotrob = i + prenotrob, max(prerob, prenotrob)
        return max(prerob, prenotrob)

    def rob2(self, nums):
        prenotrob, maxrob = 0, 0
        for i in nums:
            prenotrob, maxrob = maxrob, max(prenotrob + i, maxrob)
        return maxrob
