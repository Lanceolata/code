#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        i, j, k = -1, -1, -1
        for p in range(len(nums)):
            if nums[p] == 0:
                i, j, k = i+1, j+1, k+1
                nums[k] = 2
                nums[j] = 1
                nums[i] = 0
            elif nums[p] == 1:
                j, k = j+1, k+1
                nums[k] = 2
                nums[j] = 1
            else:
                k += 1
                nums[k] = 2
