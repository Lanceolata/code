#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def largestNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        res = "".join(sorted([str(i) for i in nums], cmp=lambda x,y:cmp(x + y, y + x), reverse=True))
        return '0' if res[0] == '0' else res