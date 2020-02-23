#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def flipAndInvertImage(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        return [[j ^ 1 for j in i[::-1]] for i in A]