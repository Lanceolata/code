#!/usr/bin/python
# coding: utf-8

import sys

class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        m = [0] * 128
        for c in t:
            m[ord(c)] += 1
        left, cnt, minLen, begin, n = 0, 0, sys.maxint, -1, len(t)
        for i in range(len(s)):
            m[ord(s[i])] -= 1
            if  m[ord(s[i])] >= 0:
                cnt += 1
            while cnt == n:
                if minLen > i - left + 1:
                    minLen = i - left + 1
                    begin = left
                m[ord(s[left])] += 1
                if m[ord(s[left])] > 0:
                    cnt -= 1
                left += 1
        if begin < 0:
            return ""
        return s[begin: begin + minLen]

