#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def compareVersion(self, version1, version2):
        """
        :type version1: str
        :type version2: str
        :rtype: int
        """
        v1 = [int(i) for i in version1.split('.')]
        v2 = [int(i) for i in version2.split('.')]
        num1, num2 = 0, 0
        for i in range(max(len(v1), len(v2))):
            if i < len(v1):
                num1 = v1[i]
            if i < len(v2):
                num2 = v2[i]
            if num1 > num2:
                return 1
            elif num1 < num2:
                return -1
            num1, num2 = 0, 0
        return 0