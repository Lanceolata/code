#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        length = len(s)
        vec = [False] * (length + 1)
        vec[0] = True
        for pos in range(length):
            if vec[pos]:
                for i in range(pos, length):
                    if s[pos : i + 1] in wordDict:
                        vec[i + 1] = True
        return vec[length]
