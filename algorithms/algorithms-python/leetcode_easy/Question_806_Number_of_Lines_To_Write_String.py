#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def numberOfLines(self, widths, S):
        """
        :type widths: List[int]
        :type S: str
        :rtype: List[int]
        """
        lines, units = 1, 0
        for c in S:
            units += widths[ord(c) - 97]
            if units > 100:
                lines += 1
                units = widths[ord(c) - 97]
        return [lines, units]