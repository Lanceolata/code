#!/usr/bin/python
# coding: utf-8

import collections

class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        count = [0] * 26
        n = ord('a')
        for c in magazine:
            count[ord(c) - n] += 1
        for c in ransomNote:
            count[ord(c) - n] -= 1
            if count[ord(c) - n] < 0:
                return False
        return True

    def canConstruct_simple(self, ransomNote, magazine):
        return not collections.Counter(ransomNote) - collections.Counter(magazine)
