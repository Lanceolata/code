#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        nums = [0] * n
        pCount = 1
        for i in range(n):
            nums[i] = i + 1
            pCount *= i + 1

        k -= 1
        res = []
        for i in range(n):
            pCount /= n - i
            select = k / pCount
            res.append(str(nums[select]))
            nums.remove(nums[select])
            k %= pCount

        return "".join(res)
