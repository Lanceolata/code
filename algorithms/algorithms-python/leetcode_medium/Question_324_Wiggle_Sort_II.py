#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def wiggleSort(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        tmp = sorted(nums)
        j, k = (len(tmp) - 1) / 2, len(tmp) - 1
        for i in range(len(nums)):
            if (i & 1) == 0:
                nums[i] = tmp[j]
                j -= 1
            else:
                nums[i] = tmp[k]
                k -= 1
