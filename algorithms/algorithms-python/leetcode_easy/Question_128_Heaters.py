#!/usr/bin/python
# coding: utf-8

import sys

class Solution(object):
    def findRadius(self, houses, heaters):
        """
        :type houses: List[int]
        :type heaters: List[int]
        :rtype: int
        """
        heaters.sort()
        n = len(heaters) - 1
        res = 0
        for house in houses:
            left, right = 0, n
            while left <= right:
                mid = left + (right - left) / 2
                if heaters[mid] > house:
                    right = mid - 1
                else:
                    left = mid + 1
            dist1 = sys.maxint if left > n else heaters[left] - house
            dist2 = sys.maxint if left <= 0 else house - heaters[left - 1]
            res = max(res, min(dist1, dist2))
        return res

sol = Solution()
print sol.findRadius([1, 2, 3], [2])
