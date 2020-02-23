#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        a = list(s)
        for i in range(0, len(s), 2 * k):
            m = i
            n = min(m + k - 1, len(s) - 1)
            while m < n:
                tmp = a[m]
                a[m] = a[n]
                a[n] = tmp
                m += 1
                n -= 1
        return "".join(a)

    def reverseStr_grace(self, s, k):
        a = list(s)
        for i in xrange(0, len(a), 2*k):
            a[i:i+k] = reversed(a[i:i+k])
        return "".join(a)
