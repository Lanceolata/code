#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def detectCapitalUse(self, word):
        """
        :type word: str
        :rtype: bool
        """
        cnt = 0
        znum = ord("Z")
        for c in word:
            if znum - ord(c) >= 0:
                cnt += 1
        return (cnt == 0) or (cnt == len(word)) or (cnt == 1 and znum - ord(word[0]) >= 0)
