#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def matrixReshape(self, nums, r, c):
        """
        :type nums: List[List[int]]
        :type r: int
        :type c: int
        :rtype: List[List[int]]
        """
        if not nums or r * c != len(nums) * len(nums[0]):
            return nums

        res = []
        for i in range(r):
            res.append([0] * c)
        row = 0
        col = 0
        for i in range(len(nums)):
            for j in range(len(nums[0])):
                res[row][col] = nums[i][j]
                col += 1
                if col == c:
                    row += 1
                    col = 0
        return res
                
