#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        dic = {')':'(', ']':'[', '}':'{'}
        for char in s:
            if char in dic.values():
                stack.append(char)
            elif char in dic.keys():
                if not stack or dic[char] != stack.pop():
                    return False
            else:
                return False
        return not stack
