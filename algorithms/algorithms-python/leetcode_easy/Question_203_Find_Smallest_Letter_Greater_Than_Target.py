#!/usr/bin/python
# coding: utf-8

import bisect

class Solution(object):
    def nextGreatestLetter(self, letters, target):
        index = bisect.bisect(letters, target)
        return letters[index % len(letters)]