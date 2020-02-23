#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def toHex(self, num):
        """
        :type num: int
        :rtype: str
        """
        # lstrip 去除左侧的‘0’
        return ''.join('0123456789abcdef'[(num >> 4 * i) & 15] 
                       for i in range(8))[::-1].lstrip('0') or '0'

