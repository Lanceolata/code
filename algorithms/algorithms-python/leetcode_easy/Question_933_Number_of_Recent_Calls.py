#!/usr/bin/python
# coding: utf-8

import collections

class RecentCounter(object):
    
    def __init__(self):
        self.q = collections.deque()

    def ping(self, t):
        """
        :type t: int
        :rtype: int
        """
        self.q.append(t)
        while self.q[0] < t-3000:
            self.q.popleft()
        return len(self.q)