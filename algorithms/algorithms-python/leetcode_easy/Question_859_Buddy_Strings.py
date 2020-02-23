#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def buddyStrings(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: bool
        """
        if len(A) != len(B):
            return False
        if A == B:
            return len(A) != len(set(A))
        ind = -1
        for i in range(len(A)):
            if A[i] != B[i]:
                if ind == -1:
                    ind = i
                elif ind == -2:
                    return False
                elif A[ind] != B[i] or A[i] != B[ind]:
                    return False
                else:
                    ind = -2
        return True