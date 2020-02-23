#!/usr/bin/python
# coding: utf-8

class NumArray(object):
    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.sum = [0]
        for num in nums:
            self.sum.append(self.sum[-1] + num)
                                            

    def sumRange(self, i, j):
        """
        :type i: int
        :type j: int
        :rtype: int
        """
        return self.sum[j + 1] - self.sum[i]
