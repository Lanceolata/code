#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def computeArea(self, A, B, C, D, E, F, G, H):
        """
        :type A: int
        :type B: int
        :type C: int
        :type D: int
        :type E: int
        :type F: int
        :type G: int
        :type H: int
        :rtype: int
        """
        res = (C - A) * (D - B) + (G - E) * (H - F);
        if A >=G or B >= H or E >= C or F >= D:
            return res
        return res - (min(G, C) - max(A, E)) * (min(D, H) - max(B, F));