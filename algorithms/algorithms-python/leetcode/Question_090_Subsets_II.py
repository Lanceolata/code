#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = [[]]
        nums.sort()
        pre, size = nums[0], 1
        for num in nums :
            if pre != num:
                pre = num
                size = len(res)
            newSize = len(res)
            for j in range(newSize - size, newSize):
                x = res[j][:]
                x.append(num)
                res.append(x)
        return res
