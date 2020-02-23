#!/usr/bin/python
# coding: utf-8

class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        result = 0
        for i in range(32):
            result = (result << 1) + (n >> i & 1)
        return result
