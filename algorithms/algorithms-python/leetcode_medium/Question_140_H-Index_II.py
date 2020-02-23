#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        length, l, r = len(citations), 0, len(citations) - 1
        while l <= r:
            mid = l + (r - l) / 2
            if citations[mid] == length - mid:
                return length - mid
            elif citations[mid] > length - mid:
                r = mid - 1
            else:
                l = mid + 1
        return length - l
            