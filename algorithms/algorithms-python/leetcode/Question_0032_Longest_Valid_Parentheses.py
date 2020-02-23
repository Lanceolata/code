#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        left, right, res = 0, 0, 0
        for i in s:
            if i == "(":
                left += 1
            else:
                right += 1
            if left == right:
                res = max(res, 2 * right)
            elif right > left:
                left , right = 0, 0
        left , right = 0, 0
        for i in s[::-1]:
            if i == "(":
                left += 1
            else:
                right += 1
            if left == right:
                res = max(res, 2 * right)
            elif left > right:
                left , right = 0, 0
        return res
