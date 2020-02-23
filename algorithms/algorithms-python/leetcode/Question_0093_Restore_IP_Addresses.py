#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        res = []
        for a in range(1, 4):
            for b in range(1, 4):
                for c in range(1, 4):
                    for d in range(1, 4):
                        if a + b + d + c == len(s):
                            A, B, C, D = int(s[0:a]), int(s[a:a+b]), int(s[a+b:a+b+c]), int(s[a+b+c:])
                            if A <= 255 and B <= 255 and C <= 255 and D <= 255:
                                tmp = "%d.%d.%d.%d" % (A, B, C, D)
                                if len(tmp) == len(s) + 3:
                                    res.append(tmp)  
        return res
