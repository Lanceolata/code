#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        if not nums:
            return res
        self.help(nums, 0, res)
        return res

    def help(self, nums, i, res):
        if i == len(nums) - 1:
            res.append(nums[:])
            return

        for j in range(i, len(nums)):
            nums[i], nums[j] = nums[j], nums[i]
            self.help(nums, i + 1, res)
            nums[i], nums[j] = nums[j], nums[i]