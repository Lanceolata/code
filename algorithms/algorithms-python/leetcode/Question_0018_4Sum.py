#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res = []
        length = len(nums)
        if length < 4:
            return res
        nums.sort()
        for m in range(length - 3):
            if m > 0 and nums[m] == nums[m - 1]:
                continue
            for n in range(m + 1, length - 2):
                if n > m + 1 and nums[n] == nums[n - 1]:
                    continue
                l, r = n + 1, length - 1
                while l < r:
                    num = nums[m] + nums[n] + nums[l] + nums[r]
                    if num == target:
                        tmp = [nums[m], nums[n], nums[l], nums[r]]
                        res.append(tmp)
                        while l < r and nums[l] == nums[l + 1]:
                            l += 1
                        while l < r and nums[r] == nums[r - 1]:
                            r -= 1
                        l += 1
                        r -= 1
                    elif num < target:
                        l += 1
                    else:
                        r -= 1
        return res
