#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        low = 0
        high = len(numbers) - 1
        res = []
        while low < high:
            sum = numbers[low] + numbers[high]
            if sum == target:
                res.append(low)
                res.append(high)
                break
            elif sum > target:
                high -= 1
            else:
                low += 1
        return res
