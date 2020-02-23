#!/usr/bin/python
# coding: utf-8

class NumArray(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        if not nums:
            return
        length = len(nums) + 1
        self.num, self.bit = [0] * length, [0] * length
        for i in range(length - 1):
            self.update(i, nums[i])
        

    def update(self, i, val):
        """
        :type i: int
        :type val: int
        :rtype: void
        """
        diff, j = val - self.num[i + 1], i + 1
        while j < len(self.num):
            self.bit[j] += diff
            j += j & (-j)
        self.num[i + 1] = val
        

    def sumRange(self, i, j):
        """
        :type i: int
        :type j: int
        :rtype: int
        """
        return self.getSum(j + 1) - self.getSum(i)


    def getSum(self, i):
        res = 0
        while i > 0:
            res += self.bit[i]
            i -= i & (-i)
        return res

sol = NumArray([1, 3, 5])
sol.sumRange(0, 2)
sol.update(1, 2)
sol.sumRange(0, 2)
