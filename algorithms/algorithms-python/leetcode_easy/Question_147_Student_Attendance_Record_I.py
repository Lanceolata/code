#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def checkRecord(self, s):
        """
        :type s: str
        :rtype: bool
        """
        cntA = 0
        cntL = 0
        for c in s:
            if c == "A":
                cntA += 1
                if cntA > 1:
                    return False
                cntL = 0
            elif c == "L":
                cntL += 1
                if cntL > 2:
                    return False;
            else:
                cntL = 0
        return True
