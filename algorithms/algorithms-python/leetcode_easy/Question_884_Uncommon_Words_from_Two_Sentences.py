#!/usr/bin/python
# coding: utf-8

import collections

class Solution(object):
    def uncommonFromSentences(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: List[str]
        """
        words = A.split() + B.split()
        ans, d = [], collections.Counter(words)
        for k in d.keys():
            if d[k] == 1:
                ans.append(k)
        return ans